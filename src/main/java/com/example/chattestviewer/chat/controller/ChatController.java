package com.example.chattestviewer.chat.controller;

import com.example.chattestviewer.chat.domain.Room;
import com.example.chattestviewer.chat.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class ChatController {
	
	private final ChattingService chattingService;

	List<Room> roomList;
	static int roomNumber = 0;

	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		return mv;
	}

	@RequestMapping("/room")
	public ModelAndView room() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("room");
		return mv;
	}

	@RequestMapping("/createRoom")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params) throws Exception {
		String roomName = (String) params.get("roomName");
		String sessionId = (String) params.get("sessionId");
		String description = (String) params.get("description");
		
		Room room_empty = new Room();
		roomList=chattingService.searchRoom(room_empty);
		
		if (roomName != null && !roomName.trim().equals("")) {
			Room room = new Room();
			room.setChat_room_num(++roomNumber);
			room.setRoom_name(roomName);
			room.setSessionId(sessionId);
			room.setDescription(description);
			chattingService.createChatRoom(room);
			roomList=chattingService.searchRoom(room);
		}
		
		return roomList;
	}

	@RequestMapping("/getRoom")
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params) throws Exception {
		Room room_empty = new Room();
		roomList=chattingService.searchRoom(room_empty);
		return roomList;
	}
	
	@RequestMapping("/getRoomUser")
	public @ResponseBody List<Room> getRoomUser(@RequestParam HashMap<String, String> params) throws Exception {

		String sessionId = params.get("ID");

		Room room_user = new Room();
		room_user.setSessionId(sessionId);
		roomList=chattingService.searchRoomUser(room_user);
		return roomList;
	}

	@RequestMapping("/moveChating")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

		List<Room> new_list = roomList.stream().filter(o -> o.getRoomNumber() == roomNumber)
				.collect(Collectors.toList());
		if (new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("chat");
		} else {
			mv.setViewName("room");
		}
		return mv;
	}
}