package com.example.chattestviewer.chat.service;


import com.example.chattestviewer.chat.domain.ChatMessage;
import com.example.chattestviewer.chat.mybatis.ChatMapper;
import com.example.chattestviewer.chat.domain.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChattingService {

    private final ChatMapper dao;

    List<Room> chatRoomList;
    List<ChatMessage> chatMessageList;

    public int createChat(ChatMessage chatMessage) throws Exception {
        return dao.createChat(chatMessage);
    }

    public int createChatRoom(Room room) throws Exception {
        return dao.createChatRoom(room);
    }

    public List<ChatMessage> searchChat(ChatMessage chatMessage) throws Exception {
        return dao.searchChat(chatMessage);
    }

    public List<Room> searchRoom(Room room) throws Exception {
        return dao.searchRoom(room);
    }

    public List<Room> searchRoomUser(Room room) throws Exception {
        return dao.searchRoomUser(room);

    }

}
