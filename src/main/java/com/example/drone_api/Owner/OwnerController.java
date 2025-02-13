package com.example.drone_api.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/owner")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(path = "{owner-id}")
    public Owner getOwner(@PathVariable("owner-id") Long id) {
        return ownerService.getOwnerById(id);
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.createOwner(owner);
    }

}
