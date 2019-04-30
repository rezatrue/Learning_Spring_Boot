package com.rezatrue.dhaka.data.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rezatrue.dhaka.data.entity.Room;
import com.rezatrue.dhaka.data.repository.RoomRepository;

@RestController
public class RoomController {
	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping(value="/rooms", method = RequestMethod.GET)
	List<Room> findAll(@RequestParam(required = false) String roomNumber){
		List<Room> rooms = new ArrayList<>();
		if(null == roomNumber) {
			Iterable<Room> results = this.roomRepository.findAll();
			results.forEach(room -> {rooms.add(room);});
		}else {
			Room room = this.roomRepository.findByNumber(roomNumber);
			if(null != room)rooms.add(room);
		}
		return rooms;
	}

}
