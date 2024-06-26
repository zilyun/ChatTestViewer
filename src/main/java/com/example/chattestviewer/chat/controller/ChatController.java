package com.example.chattestviewer.chat.controller;

import com.example.chattestviewer.chat.domain.ChatRoom;
import com.example.chattestviewer.chat.service.ChattingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {
	
	private final ChattingService chattingService;

	List<ChatRoom> chatRoomList;
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
	public @ResponseBody List<ChatRoom> createRoom(@RequestParam HashMap<Object, Object> params) throws Exception {
		String roomName = (String) params.get("roomName");
		String sessionId = (String) params.get("sessionId");
		//String description = (String) params.get("description");
		
		ChatRoom chatRoom_empty = new ChatRoom();
		chatRoomList =chattingService.searchRoom(chatRoom_empty);
		
		if (roomName != null && !roomName.trim().equals("")) {
			ChatRoom chatRoom = new ChatRoom();
			chatRoom.setChat_room_num(++roomNumber);
			chatRoom.setRoom_name(roomName);
			chatRoom.setChat_session_id(sessionId);
			//room.setDescription(description);
			chattingService.createChatRoom(chatRoom);
			chatRoomList =chattingService.searchRoom(chatRoom);
		}
		
		return chatRoomList;
	}

	@RequestMapping("/getRoom")
	public @ResponseBody List<ChatRoom> getRoom(@RequestParam HashMap<Object, Object> params) throws Exception {
		log.info("관리자용 채팅방 전체 구하기");
		ChatRoom chatRoom_empty = new ChatRoom();
		chatRoomList =chattingService.searchRoom(chatRoom_empty);
		return chatRoomList;
	}
	
	@RequestMapping("/getRoomUser")
	public @ResponseBody List<ChatRoom> getRoomUser(@RequestParam HashMap<String, String> params) throws Exception {
		log.info("아이디별 채팅방 구하기");

		String sessionId = params.get("ID");

		ChatRoom chatRoom_user = new ChatRoom();
		chatRoom_user.setChat_session_id(sessionId);
		chatRoomList =chattingService.searchRoomUser(chatRoom_user);
		return chatRoomList;
	}

	@RequestMapping("/moveChating")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		log.info("채팅방 이동");
		
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

		List<ChatRoom> new_list = chatRoomList.stream().filter(o -> o.getChat_room_num() == roomNumber)
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