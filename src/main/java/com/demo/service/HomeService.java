package com.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.home.CreateHomeDto;
import com.demo.dto.home.GetHomeDto;
import com.demo.dto.room.GetRoomDto;
import com.demo.entities.Home;
import com.demo.entities.Room;
import com.demo.iRepository.IHomeRepository;
import com.demo.iService.IHomeService;

@Service
public class HomeService implements IHomeService {

	@Autowired
	private IHomeRepository iHomeRepository;

	@Override
	public void save(CreateHomeDto dto) {
		Home newHome = new Home();
		newHome.setIpAddress(dto.getIpAddress());
		newHome.setHomeAreaKV(dto.getHomeAreaKV());

		List<Room> romList = dto.getRooms().stream().map(r ->{
			Room romRoom = new Room();
			romRoom.setRoomAreaKV(r.getRoomAreaKV());
			romRoom.setWhichRoom(r.getWhichRoom());
			romRoom.setHome(newHome);
			return romRoom;
		}).toList();
		
		newHome.setRooms(romList);
		iHomeRepository.save(newHome);
	}

	@Override
	public void delete(UUID id) {
		 Home home = iHomeRepository.findByIdWithRooms(id)
			        .orElseThrow(() -> new RuntimeException("Home not found"));
		 iHomeRepository.delete(home);
	}

	@Override
	public List<GetHomeDto> getAll() {
		List<Home> homes = iHomeRepository.findAll();
		
		return homes.stream().map(home -> {
			List<GetRoomDto> getRoomDtos = home.getRooms().stream().map(room ->{
				 return new GetRoomDto(
			                room.getId(),
			                room.getWhichRoom(),
			                room.getRoomAreaKV()
			            );
			}).toList();
			
			 return new GetHomeDto(
			            home.getId(),
			            home.getIpAddress(),
			            home.getHomeAreaKV(),
			            getRoomDtos
			        );
		}).toList();
	}

	@Override
	public GetHomeDto findBy(UUID id) {
	    Home home = iHomeRepository.findByIdWithRooms(id)
	        .orElseThrow(() -> new RuntimeException("Home not found"));

	    List<GetRoomDto> roomDtos = home.getRooms().stream().map(room ->
	        new GetRoomDto(
	            room.getId(),
	            room.getWhichRoom(),
	            room.getRoomAreaKV()
	        )
	    ).toList();

	    return new GetHomeDto(
	        home.getId(),
	        home.getIpAddress(),
	        home.getHomeAreaKV(),
	        roomDtos
	    );
	}


}
