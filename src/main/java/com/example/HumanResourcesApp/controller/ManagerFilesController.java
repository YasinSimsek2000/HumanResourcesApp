package com.example.HumanResourcesApp.controller;


import com.example.HumanResourcesApp.entity.ManagerFiles;
import com.example.HumanResourcesApp.service.ManagerFilesService;
import com.example.HumanResourcesApp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Path;


@RestController
@CrossOrigin("*")
public class ManagerFilesController {
    @Autowired
    ManagerFilesService managerFilesService;

    @Autowired
    ManagerService managerService;

    @RequestMapping(value = "/createNewManagerFile{id}", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewManagerFile
            (@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        Path path = Path.of("C:\\Users\\ysimsek\\Documents\\yasin\\" + fileName);
        String filePath = path.toString();
        file.transferTo(path);
        ManagerFiles managerFile = new ManagerFiles(managerService.getManagerByID(id).get(), fileType, fileName, filePath);
        managerFilesService.createManagerFiles(managerFile);
        return new ResponseEntity<> (managerService.getManagerByID(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/deleteManagerFiles", method = RequestMethod.DELETE)
    public void deleteManagerFiles (Long id ) {
        managerFilesService.deleteManagerFiles(id);
    }

    @RequestMapping(value = "/getManagerFilesByManagerID")
    public ResponseEntity<Object> getManagerFilesByManagerID (@RequestBody String email) {
        return new ResponseEntity<>
                (managerService.getManagerByMail(email).get().getManagerFiles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/updateManagerFiles", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateManagerFiles (@RequestBody Object[] newFileData) {
        managerFilesService.updateManagerFiles((Long) newFileData[0], (ManagerFiles) newFileData[1]);
        return new ResponseEntity<>((ManagerFiles) newFileData[1], HttpStatus.OK);
    }
}
