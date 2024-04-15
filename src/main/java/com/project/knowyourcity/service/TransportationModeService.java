package com.project.knowyourcity.service;

import com.project.knowyourcity.dto.TransportationModeDto;
import com.project.knowyourcity.entity.TransportationMode;
import com.project.knowyourcity.repository.CityRepository;
import com.project.knowyourcity.repository.TransportationModeRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportationModeService {
    @Autowired
    private TransportationModeRepository transportationModeRepo;
    @Autowired
    private CityRepository cityRepo;
    public TransportationModeDto insertNewTransportation(TransportationModeDto newTransportation) throws Exception {

        Optional<TransportationMode> temp = transportationModeRepo.findAllByModeAndCost(newTransportation.getMode(),newTransportation.getCostLevel());
        if(temp.isPresent()){
            throw new Exception("Transportation mode already exists");
        }

        TransportationMode tempTransportation = TransportationMode.builder()
                .mode(newTransportation.getMode())
                .costLevel(newTransportation.getCostLevel())
                .build();

        TransportationMode transportation1 = transportationModeRepo.save(tempTransportation);

        return TransportationModeDto.builder()
                .transportationModeId(transportation1.getTransportationModeId())
                .mode(transportation1.getMode())
                .costLevel(transportation1.getCostLevel())
                .build();
    }
}
