
package com.example.demo.controller;

import com.example.demo.entity.QueuePosition;
import com.example.demo.service.impl.QueueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueServiceImpl service;

    @PostMapping("/update-position/{id}")
    public void updateQueuePosition(@PathVariable Long id, @RequestParam Integer position) {
        service.updateQueuePosition(id, position); // method returns void
    }

    @GetMapping("/get-position/{id}")
    public Integer getPosition(@PathVariable Long id) {
        return service.getPosition(id); // returns Integer
    }
}
