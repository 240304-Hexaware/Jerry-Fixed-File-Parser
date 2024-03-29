package com.revature.springserver.controller;

import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.FixedFile;
import com.revature.springserver.model.SpecificationFile;
import com.revature.springserver.service.FixedFileService;
import com.revature.springserver.service.RecordService;
import com.revature.springserver.service.SpecificationFileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Controller that defines REST endpoints and handles HTTP Requests for FixedFile
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class FixedFileController {

    private FixedFileService fixedFileService;
    private RecordService recordService;
    private SpecificationFileService specificationFileService;

    @Autowired
    public FixedFileController(FixedFileService fixedFileService, RecordService recordService,
                               SpecificationFileService specificationFileService) {
        this.fixedFileService = fixedFileService;
        this.recordService = recordService;
        this.specificationFileService = specificationFileService;
    }

    /**
     * POST /api/fixed-files
     * Upload a fixed-length file.
     */
    @PostMapping("/fixed-files")
    public FixedFile upload(@RequestParam String userId, @RequestParam String specFileId, @RequestBody MultipartFile file) throws IOException, NotFoundException {
        // Pull in map from spec
        SpecificationFile specFile = specificationFileService.findSpecificationFile(specFileId);
        // Upload the fixed file
        FixedFile fixedFile = fixedFileService.uploadFixedFile(userId, file);
        String data = fixedFileService.readAllBytesFromFile(fixedFile);
        // Parse the fixed file based on spec map
        String[][] recordArray = fixedFileService.readStringFields(data, SpecificationFileService.parseSpec(new File(specFile.getFilePath())));
        // Generate records from recordService
        recordService.addRecord(userId, specFileId, recordArray[0], recordArray[1]);

        return fixedFile;
    }

    /**
     *
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/fixed-files")
    public List<FixedFile> getAllFixedFiles() throws NotFoundException {
        return fixedFileService.getAllFixedFiles();
    }


    /**
     * GET /api/fixed-files/users/{userId}
     * Get all fixed files uploaded by a user
     */
    @GetMapping("/fixed-files/users/{userId}")
    public List<FixedFile> getFixedFilesListByUser(@PathVariable String userId) throws NotFoundException {
        return fixedFileService.getFixedFileListByUser(userId);
    }

    //Exception Handlers
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(IOException e) {
        //TODO: change this out for a log message
        System.out.println(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(NotFoundException e) {
        //TODO: change this out for a log message
        System.out.println(e.getMessage());
        return e.getMessage();
    }

}
