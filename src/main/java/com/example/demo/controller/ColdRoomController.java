package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.ColdRoom;
import com.example.demo.service.ColdRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cold-rooms")
public class ColdRoomController {

    private final ColdRoomService coldRoomService;

    public ColdRoomController(ColdRoomService coldRoomService) {
        this.coldRoomService = coldRoomService;
    }

    @PostMapping
    public ColdRoomResponse create(@RequestBody ColdRoomRequest request) {

        ColdRoom room = new ColdRoom(
                request.getName(),
                request.getLocation(),
                request.getMinAllowed(),
                request.getMaxAllowed()
        );

        ColdRoom saved = coldRoomService.createColdRoom(room);

        return new ColdRoomResponse(
                saved.getId(),
                saved.getName(),
                saved.getLocation(),
                saved.getMinAllowed(),
                saved.getMaxAllowed()
        );
    }

    @GetMapping
    public List<ColdRoomResponse> getAll() {
        return coldRoomService.getAllColdRooms()
                .stream()
                .map(r -> new ColdRoomResponse(
                        r.getId(), r.getName(), r.getLocation(),
                        r.getMinAllowed(), r.getMaxAllowed()))
                .collect(Collectors.toList());
    }
}
