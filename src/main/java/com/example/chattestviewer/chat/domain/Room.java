package com.example.chattestviewer.chat.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Setter
@Getter
public class Room {
//	int roomNumber;
//	String roomName;
//	String sessionId;
//	String description;

	private long chat_room_num;
	private String chat_session_id;
	private String name;
	private Date date;

}