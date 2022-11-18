package br.com.parking.controller;

import br.com.parking.controller.DTO.ParkingCreateDTO;
import br.com.parking.controller.DTO.ParkingDTO;
import br.com.parking.controller.mapper.ParkingMapper;
import br.com.parking.model.Parking;
import br.com.parking.service.ParkingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {


    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;


    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        return ResponseEntity.ok(parkingMapper.toParkingDTOList(parkingList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO parkingDTO){
        Parking parking = parkingService.create(parkingMapper.toParkingCreate(parkingDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingMapper.toParkingDTO(parking));
    }
}
