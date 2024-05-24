package com.example.chattestviewer.chat.mybatis;

import com.example.chattestviewer.chat.domain.ChatMessage;
import com.example.chattestviewer.chat.domain.Room;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChattingDAO {
	
	@Autowired
	SqlSession sqlSession = null;
	
	public int create_chat(ChatMessage chatMessage) throws Exception {
		return sqlSession.insert("chat_content.chat_create", chatMessage);
	}
	
	public int create_chatting_room(Room room) throws Exception {
		return sqlSession.insert("chat.room_create",room);
	}
	
	public List<Room> search_room(Room room) throws Exception {
		return sqlSession.selectList("chat.search_room");	
	}
	
	public List<Room> search_roomUser(Room room) throws Exception {
		return sqlSession.selectList("chat.search_roomUser",room);	
	}
	
	public List<ChatMessage> search_chat(ChatMessage chatMessage) throws Exception {
		return sqlSession.selectList("chat_content.search_chat", chatMessage);
	}
}
