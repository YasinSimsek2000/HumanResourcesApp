package com.example.HumanResourcesApp.service;

import com.example.HumanResourcesApp.entity.Employee;
import com.example.HumanResourcesApp.entity.Files;
import com.example.HumanResourcesApp.entity.Manager;
import com.example.HumanResourcesApp.repository.IFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FilesService implements IFilesService {

    @Autowired
    IFilesRepository filesRepository;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ManagerService managerService;
    @Autowired
    ProjectService projectService;

    public void createFile (Long ID, String Class, MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        Path path = findPath(Class, ID, fileName);
        String filePath = path.toString();
        file.transferTo(path);
        Files newFile = new Files(fileType, fileName, filePath);
        saveFile(Class, ID, newFile);
    }

    public void createFile (Long ID, String Class, File file) throws Exception {
        String fileName = file.getName();
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        Path path = findPath(Class, ID, fileName);
        String filePath = path.toString();
        java.nio.file.Files.copy(file.toPath(), Path.of(filePath),
                StandardCopyOption.REPLACE_EXISTING);
        Files newFile = new Files(fileType, fileName, filePath);
        saveFile(Class, ID, newFile);
    }

    @Override
    public void deleteFiles(String fileName) {
        filesRepository.deleteFilesByFileName(fileName);
        filesRepository.saveAll(filesRepository.findAll());
    }

    @Override
    public List<Files> getFiles() { return filesRepository.findAll(); }

    @Override
    public Files getFileByName(String fileName) {
        if (filesRepository.findFilesByFileName(fileName).isPresent()) {
            return filesRepository.findFilesByFileName(fileName).get();
        }

        else { return null; }
    }

    @Override
    public void updateFileName(Long id, String newFileName) {
        if (filesRepository.findById(id).isPresent()) {
            filesRepository.findById(id).get().setFileName(newFileName);
        }
    }

    public void saveFile (String Class, Long ID, Files newFile) throws Exception {
        switch (Class) {
            case "Department" -> newFile.setDepartment(departmentService.getDepartmentById(ID));
            case "Employee" -> newFile.setEmployee(employeeService.getEmployeeById(ID));
            case "Manager" ->  {
                if (managerService.getManagerByID(ID).isPresent()) { newFile.setManager(managerService.getManagerByID(ID).get()); }
            }
            case "Project" -> newFile.setProject(projectService.getProjectById(ID));
            default -> throw new Exception("Invalid try");
        } filesRepository.save(newFile);
    }

    public Path findPath (String Class, Long ID, String fileName) throws Exception {
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
                if (managerService.getManagerByID(ID).isPresent()) {
                    Manager manager = managerService.getManagerByID(ID).get();
                    path += "Managers";
                    path2 += ID + "_" + manager.getName() + "_" + manager.getSurname();
                }
            }
            case "Project" -> {
                path += "Projects";
                path2 += ID + "_" + projectService.getProjectById(ID).getProject_name();
            }
            default -> throw new Exception("Invalid try");
        }

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

        if (fileName == null) { return Path.of(path); }
        return Path.of(path + "\\" + fileName);
    }
}
