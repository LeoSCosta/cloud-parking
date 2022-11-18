package br.com.parking.service;


import br.com.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "DES-3783", "RJ" , "MONZA", "PRETO");
        parkingMap.put(id,parking);

        var id2 = getUUID();
        Parking parking2 = new Parking(id, "GOD-1994", "SP" , "C5", "CINZA");
        parkingMap.put(id2,parking2);
    }

    public List<Parking> findAll(){
        return new ArrayList<>(parkingMap.values());
    }



    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());

        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;

    }
}
