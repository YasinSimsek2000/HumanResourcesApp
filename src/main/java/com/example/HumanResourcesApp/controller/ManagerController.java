package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.dto.ManagerDto;
import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;

@RestController
@CrossOrigin("*")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping(value = "/checkManager", method = RequestMethod.POST)
    public void checkManager (@RequestBody ManagerDto managerDto) throws Exception {
        if (managerService.getManagerByMail(managerDto.getEmail()).isEmpty()) {
            throw new Exception("There is no existing manager with the same mail address.");
        }

        else if (!Objects.equals(managerService.hashPassword(managerDto.getPassword()), managerService.getManagerByMail(managerDto.getEmail()).get().getPassword())) {
            throw new Exception("Wrong password!");
        }

        else {
            try {
                FileWriter writer = new FileWriter("currentUser.txt");
                BufferedWriter write = new BufferedWriter(writer);

                Manager manager = managerService.getManagerByMail(managerDto.getEmail()).get();
                write.write(manager.getId() + "\n");
                write.write(manager.getEmail() + "\n");
                write.write(manager.getName() + "\n");
                write.write(manager.getSurname());

                write.close();
                writer.close();
            } catch (Exception ignored) {}
        }
    }

    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public ResponseEntity<Object> getCurrentUser () {
        try {
            FileReader reader = new FileReader("currentUser.txt");
            BufferedReader read = new BufferedReader(reader);

            String line = read.readLine();
            String[] data = new String[4];
            int x = 0;

            while (line != null) {
                data[x++] = line;
                line = read.readLine();
            }

            read.close();
            reader.close();

            System.out.println(data);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception ignored) {return null;}
    }

    @RequestMapping(value = "/createManager", method = RequestMethod.POST)
    public ResponseEntity<Object> createManager (@RequestBody Manager manager) throws Exception {
        if (managerService.getManagerByMail(manager.getEmail()).isPresent()) {
            throw new Exception("There is an existing manager with the same mail address.");
        }

        else {
            managerService.createManager(manager);
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
        if (managerService.getManagerByMail(email).isPresent()) {
            return new ResponseEntity<>(managerService.getManagerByMail(email).get().getFiles(), HttpStatus.OK);
        }

        else { return null; }
    }

    @RequestMapping(value = "/updateManager", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateManager (@RequestBody ManagerDto managerdto) {
        managerService.updateManager(managerdto);
        return new ResponseEntity<>(managerdto, HttpStatus.OK);
    }
}
