package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.dto.ManagerDto;
import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ManagerController {
    @Autowired
    ManagerService ManagerService;

    @RequestMapping(value = "/createManager", method = RequestMethod.POST)
    public ResponseEntity<Object> createManager (@RequestBody Manager manager) {
        ManagerService.createManager(manager);
        return new ResponseEntity<>(manager, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteManager", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteManager (@RequestBody Long id) {
        ManagerService.deleteManager(id);
        return new ResponseEntity<>(ManagerService.getManager(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getManagers", method = RequestMethod.GET)
    public ResponseEntity<Object> getManagers () {
        return new ResponseEntity<>(ManagerService.getManager(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getManagerByMail", method = RequestMethod.GET)
    public ResponseEntity<Object> getManagerByMail (@RequestBody String email) {
        return new ResponseEntity<>(ManagerService.getManagerByMail(email), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateManager", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateManager (@RequestBody ManagerDto managerdto) {
        ManagerService.updateManager(managerdto);
        return new ResponseEntity<>(managerdto, HttpStatus.OK);
    }
}
