package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.model.parkingLot;
import com.thoughtworks.parking_lot.repository.parkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class parkingLotController {

    @Autowired
    private parkingLotRepository parkingLotRepository;


    @GetMapping("/parking-lots")
    public ResponseEntity<List<parkingLot>> getParkingLots(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "pageSize",defaultValue = "15") int pageSize){

        return ResponseEntity.ok(parkingLotRepository
                .findAll()
                .subList(Math.min((page - 1)* pageSize,0),Math.min((page*pageSize),parkingLotRepository.findAll().size())));
    }

    @GetMapping("/parking-lots/{Name}")
    public ResponseEntity<parkingLot> getSpecifyParkingLot(@PathVariable String Name){

        return ResponseEntity.ok(parkingLotRepository.findById(Name).orElse(null));
    }

    @PostMapping("/parking-lots")
    public ResponseEntity createParkingLot(@RequestBody parkingLot parkingLot){
        if(parkingLot.getCapacity() < 0)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(parkingLotRepository.save(parkingLot));
    }

    @PutMapping("/parking-lots/{Name}")
    public ResponseEntity updateParkingLot(@PathVariable String Name,@RequestBody parkingLot parkingLot){
        if(parkingLotRepository.existsById(Name)){
            parkingLotRepository.deleteById(Name);
            return ResponseEntity.ok(parkingLotRepository.save(parkingLot));
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/parking-lots/{Name}")
    public ResponseEntity deleteParkingLot(@PathVariable String Name){
        boolean isExist = parkingLotRepository.existsById(Name);
        if(isExist){
            parkingLotRepository.deleteById(Name);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }
}
