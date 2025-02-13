package com.example.drone_api.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner createOwner(Owner to_create) {
        ownerRepository.save(to_create);
        return to_create;
    }

//    public Owner addDrone(Long owner_id, Long drone_id) {
//
//    }

}
