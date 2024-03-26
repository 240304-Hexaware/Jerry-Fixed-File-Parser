package com.revature.springserver.controller;

import com.revature.springserver.model.SpecificationFile;
import com.revature.springserver.service.SpecificationFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Controller that defines REST endpoints and handles HTTP Requests for SpecificationFile
 */
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

    // Exception Handler
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryNotFound(IOException e) {
        //TODO: change this out for a log message
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
