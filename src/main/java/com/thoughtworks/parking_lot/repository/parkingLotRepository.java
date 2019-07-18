package com.thoughtworks.parking_lot.repository;


import com.thoughtworks.parking_lot.model.parkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface parkingLotRepository extends JpaRepository<parkingLot,String> {

}
