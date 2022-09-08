package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.dto.ManagerDto;
import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@CrossOrigin("*")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @Autowired
    FilesController filesController;

    @RequestMapping(value = "/checkManager", method = RequestMethod.POST)
    public void checkManager (@RequestBody ManagerDto managerDto) throws Exception {
        if (managerService.getManagerByMail(managerDto.getEmail()).isEmpty()) {
            throw new Exception("There is no existing manager with the same mail address.");
        }

        else if (!Objects.equals(managerService.hashPassword(managerDto.getPassword()), managerService.getManagerByMail(managerDto.getEmail()).get().getPassword())) {
            throw new Exception("Wrong password!");
        }
    }

    @RequestMapping(value = "/createManager", method = RequestMethod.POST)
    public ResponseEntity<Object> createManager (@RequestBody Manager manager) throws Exception {
        if (managerService.getManagerByMail(manager.getEmail()).isPresent()) {
            throw new Exception("There is an existing manager with the same mail address.");
        }

        else {
            managerService.createManager(manager);
            try {
                File profilePhoto = new File("C:\\Users\\ysimsek\\Documents\\ProfilePhoto.png");
                Files.copy(Paths.get("C:\\Users\\ysimsek\\Downloads\\HumanResourcesApp" +
                                "\\HumanResourcesApp\\Human Resources Application Files\\ProfilePhoto.png"),
                        Paths.get("C:\\Users\\ysimsek\\Downloads\\HumanResourcesApp" +
                                "\\HumanResourcesApp\\Human Resources Application Files\\Managers\\" +
                                manager.getId() + " - " + manager.getName() + " " + manager.getSurname() + "\\ProfilePhoto.png"));
            } catch (FileAlreadyExistsException ignored){}

            return new ResponseEntity<>(manager, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/deleteManager", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteManager (@RequestBody Long id) {
        managerService.deleteManager(id);
        return new ResponseEntity<>(managerService.getManager(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getManagers", method = RequestMethod.GET)
    public ResponseEntity<Object> getManagers () {
        return new ResponseEntity<>(managerService.getManager(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getManagerByMail", method = RequestMethod.GET)
    public ResponseEntity<Object> getManagerByMail (@RequestBody String email) {
        return new ResponseEntity<>(managerService.getManagerByMail(email), HttpStatus.OK);
    }

    @RequestMapping(value = "/getManagerFilesByMail/{email}", method = RequestMethod.GET)
    public ResponseEntity<Object> getManagerFilesByMail (@PathVariable("email") String email) {
        return new ResponseEntity<>(managerService.getManagerByMail(email).get().getFiles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateManager", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateManager (@RequestBody ManagerDto managerdto) {
        managerService.updateManager(managerdto);
        return new ResponseEntity<>(managerdto, HttpStatus.OK);
    }


}
