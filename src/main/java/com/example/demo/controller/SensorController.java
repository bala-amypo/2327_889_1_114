package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final ColdRoomService coldRoomService;

    public SensorController(SensorService sensorService,
                            ColdRoomService coldRoomService) {
        this.sensorService = sensorService;
        this.coldRoomService = coldRoomService;
    }

    @PostMapping
    public SensorResponse add(@RequestBody SensorRequest request) {

        ColdRoom room = coldRoomService.getById(request.getColdRoomId());

        SensorDevice sensor = new SensorDevice(
                request.getIdentifier(),
                room,
                request.getIsActive()
        );

        SensorDevice saved = sensorService.addSensor(sensor);

        return new SensorResponse(
                saved.getId(),
                saved.getIdentifier(),
                room.getId(),
                room.getName(),
                saved.getIsActive()
        );
    }

    @PutMapping("/{id}/status")
    public SensorDevice updateStatus(@PathVariable Long id,
                                     @RequestParam Boolean active) {
        return sensorService.updateStatus(id, active);
    }

    @GetMapping
    public List<SensorDevice> getAll() {
        return sensorService.getAllSensors();
    }
}
