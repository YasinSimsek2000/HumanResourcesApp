package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.entity.Files;
import com.example.HumanResourcesApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Path;

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
    public ResponseEntity<Object> createNewFile
            (@PathVariable("ID") Long ID, @PathVariable("Class") String Class,
             @RequestParam("file") MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        Path path = Path.of("C:\\Users\\ysimsek\\Documents\\yasin\\" + fileName);
        String filePath = path.toString();
        file.transferTo(path);
        Files newFile = new Files(fileType, fileName, filePath);
        saveFile(Class, ID, newFile);
        return new ResponseEntity<> (newFile.getFileName(), HttpStatus.OK);
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

    private void saveFile (String Class, Long ID, Files newFile) throws Exception {
        switch (Class) {
            case "Department" -> newFile.setDepartment(departmentService.getDepartmentById(ID));
            case "Employee" -> newFile.setEmployee(employeeService.getEmployeeById(ID));
            case "Manager" -> newFile.setManager(managerService.getManagerByID(ID).get());
            case "Project" -> newFile.setProject(projectService.getProjectById(ID));
            default -> throw new Exception("Invalid try");
        }

        filesService.createFiles(newFile);
    }
}
