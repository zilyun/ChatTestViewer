package com.example.chattestviewer.chat.mybatis;

import com.example.chattestviewer.chat.domain.ChatMessage;
import com.example.chattestviewer.chat.domain.ChatRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {

    public int createMessage(ChatMessage chatMessage);

    public int createChatRoom(ChatRoom chatRoom);

    public List<ChatRoom> searchRoom(ChatRoom chatRoom);

    public List<ChatRoom> searchRoomUser(ChatRoom chatRoom);

    public List<ChatMessage> searchMessages(ChatMessage chatMessage);

}
