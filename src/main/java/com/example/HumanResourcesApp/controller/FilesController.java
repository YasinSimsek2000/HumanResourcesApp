package com.example.HumanResourcesApp.controller;

import com.example.HumanResourcesApp.entity.Employee;
import com.example.HumanResourcesApp.entity.Files;
import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
        Path path = findPath(Class, ID, fileName);
        String filePath = path.toString();
        file.transferTo(path);
        Files newFile = new Files(fileType, fileName, filePath);
        saveFile(Class, ID, newFile);
        return new ResponseEntity<> (newFile.getFileName(), HttpStatus.OK);
    }
    public void createNewFile ( Long ID, String Class, File file) throws Exception {
        String fileName = file.getName();
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        Path path = findPath(Class, ID, fileName);
        String filePath = path.toString();
        java.nio.file.Files.copy(file.toPath(), Path.of(filePath),
                StandardCopyOption.REPLACE_EXISTING);
        Files newFile = new Files(fileType, fileName, filePath);
        saveFile(Class, ID, newFile);
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

    private Path findPath (String Class, Long ID, String fileName) throws Exception {
        String path = "C:\\Users\\ysimsek\\Downloads\\HumanResourcesApp\\" +
                "HumanResourcesApp\\Human_Resources_Application_Files\\";
        String path2 = "\\";

        switch (Class) {
            case "Department" -> {
                path += "Departments";
                path2 += ID + "_" + departmentService.getDepartmentById(ID).getDepartment_name();
            }
            case "Employee" -> {
                Employee employee = employeeService.getEmployeeById(ID);
                path += "Employees";
                path2 += ID + "_" + employee.getName() + "_" + employee.getSurname();
            }
            case "Manager" -> {
                Manager manager = managerService.getManagerByID(ID).get();
                path += "Managers";
                path2 += ID + "_" + manager.getName() + "_" + manager.getSurname();
            }
            case "Project" -> {
                path += "Projects";
                path2 += ID + "_" + projectService.getProjectById(ID).getProject_name();
            }
            default -> throw new Exception("Invalid try");
        };

        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()) { System.out.println("File is created successfully."); }
            else { System.out.println("File is not created. Check the problem."); }
        }

        path += path2;

        file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()) { System.out.println("File is created successfully."); }
            else { System.out.println("File is not created. Check the problem."); }
        }

        return Path.of(path + "\\" + fileName);
    }
}
