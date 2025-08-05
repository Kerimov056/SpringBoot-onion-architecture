package com.demo.dto.home;

import java.util.List;
import java.util.UUID;

import com.demo.dto.room.GetRoomDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHomeDto {
	private UUID id;
	private String ipAddress;
	private String homeAreaKV;
	private List<GetRoomDto> getRoomDtos;
}
