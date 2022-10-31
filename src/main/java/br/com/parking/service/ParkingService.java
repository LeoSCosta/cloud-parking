package br.com.parking.service;


import br.com.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "DES-3783", "RJ" , "MONZA", "PRETO");
        parkingMap.put(id,parking);
    }

    public List<Parking> findAll(){
        return new ArrayList<>(parkingMap.values());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
