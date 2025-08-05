package com.demo.dto.room;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomDto {
	
	@NotEmpty(message = "whichRoom mutleq olmalidir.!!!")
	@NotNull(message = "whichRoom null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 3, max = 30, message = "min 2 max 30 olmalidir")
	private String whichRoom;
	
	@NotEmpty(message = "roomAreaKV mutleq olmalidir.!!!")
	@NotNull(message = "roomAreaKV null ola bilmez ! mutleq olmalidir.!!!")
	@Size(min = 3, max = 30, message = "min 2 max 50 olmalidir")
	private String roomAreaKV;
}
