package com.revature.springserver.controller;

import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.SpecificationFile;
import com.revature.springserver.service.SpecificationFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Controller that defines REST endpoints and handles HTTP Requests for SpecificationFile
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class SpecificationFileController {
    private SpecificationFileService specificationFileService;

    @Autowired
    public SpecificationFileController(SpecificationFileService specificationFileService) {
        this.specificationFileService = specificationFileService;
    }

    /**
     * POST /api/specifications
     * Upload a custom specification file
     */
    @PostMapping("/specifications")
    public SpecificationFile upload(@RequestParam String userId, @RequestBody MultipartFile file) throws IOException {
        return specificationFileService.uploadSpecificationFile(userId, file);
    }

    /**
     * GET /api/specifications/{userId}
     * Get all specification files uploaded by a user
     */
    @GetMapping("/specifications/{userId}")
    public List<SpecificationFile> getSpecificationFileByUser(@PathVariable String userId) throws NotFoundException {
        return specificationFileService.getSpecificationFileListByUser(userId);
    }

    @GetMapping("/specifications")
    public List<SpecificationFile> getAllSpecificationFiles(){
        return specificationFileService.getAllSpecificationFiles();
    }



    // Exception Handler
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(IOException e) {
        return e.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(NotFoundException e) {
        return e.getMessage();
    }
}
