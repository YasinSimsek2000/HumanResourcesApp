package com.example.HumanResourcesApp.controller;


import com.example.HumanResourcesApp.entity.Notification;
import com.example.HumanResourcesApp.service.ManagerService;
import com.example.HumanResourcesApp.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    ManagerService managerService;

    @RequestMapping(value = "/newMessage/{to}", method = RequestMethod.POST)
    public void newMessage (@PathVariable("to") Long to, @RequestBody Notification notification) {
        notificationService.newMessage(notification, to);
    }

    @RequestMapping(value = "/deleteMessage/{ID}", method = RequestMethod.DELETE)
    public void deleteMessage (@PathVariable("ID") Long ID) {
        notificationService.deleteMessage(ID);
    }

    @RequestMapping(value = "/getMessages", method = RequestMethod.GET)
    public ResponseEntity<Object> getMessages () {
        return new ResponseEntity<>(notificationService.getMessages(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getMessages/{ID}", method = RequestMethod.GET)
    public ResponseEntity<Object> getMessagesByID (@PathVariable("ID") Long ID) {
        return new ResponseEntity<>(managerService.getManagerByID(ID).get().getNotification(), HttpStatus.OK);
    }
}
