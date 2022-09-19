package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class FilesController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    FilesService filesService;
    @Autowired
    ManagerService managerService;
    @Autowired
    ProjectService projectService;
    @RequestMapping(value = "/createNewFile/{Class}/{ID}", method = RequestMethod.POST)
    public void createFile (@PathVariable("ID") Long ID, @PathVariable("Class") String Class,
             @RequestParam("file") MultipartFile file) throws Exception {
        filesService.createFile(ID, Class, file);
    }

    @RequestMapping(value = "/deleteFiles", method = RequestMethod.DELETE, produces={"application/json; charset=UTF-8"})
    public ResponseEntity<Object> deleteFiles (@RequestBody String fileName) {
        filesService.deleteFiles(fileName);
        return new ResponseEntity<>(filesService.getFiles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getFiles")
    public ResponseEntity<Object> getFiles () {
        return new ResponseEntity<>(filesService.getFiles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getFilesByName", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getFilesByName (@RequestBody String fileName) {
        return new ResponseEntity<>(filesService.getFileByName(fileName), HttpStatus.OK);
    }

    @RequestMapping(value = "updateFileNameById/{ID}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateFileNameById (@PathVariable("ID") Long ID, @RequestBody String newFileName) {
        filesService.updateFileName(ID, newFileName);
        return new ResponseEntity<>(filesService.getFileByName(newFileName), HttpStatus.OK);
    }


}
