package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {
    @Autowired
    ManagerService ManagerService;

    @RequestMapping(value = "/managers", method = RequestMethod.POST)
    public ResponseEntity<Object> createManager (@RequestBody Manager manager) {
        ManagerService.createManager(manager);
        return new ResponseEntity<>(manager, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Managers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteManager (@PathVariable("id") Long id) {
        ManagerService.deleteManager(id);
        return new ResponseEntity<>(ManagerService.getManager(), HttpStatus.OK);
    }

    @RequestMapping(value = "/Managers", method = RequestMethod.GET)
    public ResponseEntity<Object> getManagers () {
        return new ResponseEntity<>(ManagerService.getManager(), HttpStatus.OK);
    }

    @RequestMapping(value = "/Managers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateManager (@PathVariable("id") Long id, @RequestBody Manager manager) {
        ManagerService.updateManager(id, manager);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }
}
