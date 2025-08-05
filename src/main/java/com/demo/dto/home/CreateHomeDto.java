package com.demo.dto.home;

import java.util.List;

import com.demo.dto.room.CreateRoomDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHomeDto {
	
	@NotEmpty(message = "ipAddress mutleq olmalidir.!!!")
	@NotNull(message = "ipAddress null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 3, max = 80, message = "min 2 max 80 olmalidir")
	private String ipAddress;
	
	@NotEmpty(message = "homeAreaKV mutleq olmalidir.!!!")
	@NotNull(message = "homeAreaKV null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 3, max = 30, message = "min 2 max 50 olmalidir")
    private String homeAreaKV;
	
    private List<CreateRoomDto> rooms;
}
