package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.model.parkingLot;
import com.thoughtworks.parking_lot.repository.parkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class parkingLotController {

    @Autowired
    private parkingLotRepository parkingLotRepository;


    @GetMapping("/parking-lots")
    public ResponseEntity<List<parkingLot>> getParkingLots(){
        return ResponseEntity.ok(parkingLotRepository.findAll());
    }

    @PostMapping("/parking-lots")
    public ResponseEntity createParkingLots(@RequestBody parkingLot parkingLot){
        if(parkingLot.getCapacity() < 0)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(parkingLotRepository.save(parkingLot));
    }
}
