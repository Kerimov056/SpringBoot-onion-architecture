package com.demo.dto.room;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomDto {
	private UUID id;
	private String whichRoom;
	private String roomAreaKV;
}
