package com.example.chattestviewer.chat.mybatis;

import com.example.chattestviewer.chat.domain.ChatMessage;
import com.example.chattestviewer.chat.domain.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {

    public int createChat(ChatMessage chatMessage);

    public int createChatRoom(Room room);

    public List<Room> searchRoom(Room room);

    public List<Room> searchRoomUser(Room room);

    public List<ChatMessage> searchChat(ChatMessage chatMessage);

}
