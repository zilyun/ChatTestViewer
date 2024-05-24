package com.example.chattestviewer.chat.service;


import com.example.chattestviewer.chat.domain.ChatMessage;
import com.example.chattestviewer.chat.domain.ChatRoom;
import com.example.chattestviewer.chat.mybatis.ChatMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChattingService {

    private final ChatMapper dao;

    List<ChatRoom> chatChatRoomList;
    List<ChatMessage> chatMessageList;

    public int createMessage(ChatMessage chatMessage) throws Exception {
        return dao.createMessage(chatMessage);
    }

    public int createChatRoom(ChatRoom chatRoom) throws Exception {
        return dao.createChatRoom(chatRoom);
    }

    public List<ChatMessage> searchMessages(ChatMessage chatMessage) throws Exception {
        return dao.searchMessages(chatMessage);
    }

    public List<ChatRoom> searchRoom(ChatRoom chatRoom) throws Exception {
        return dao.searchRoom(chatRoom);
    }

    public List<ChatRoom> searchRoomUser(ChatRoom chatRoom) throws Exception {
        return dao.searchRoomUser(chatRoom);
    }

}
