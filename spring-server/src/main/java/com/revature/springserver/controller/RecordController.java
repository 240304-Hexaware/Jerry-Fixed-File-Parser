package com.revature.springserver.controller;

import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.Record;
import com.revature.springserver.service.RecordService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller that defines REST endpoints and handles HTTP Requests for Record
 */
@RestController
@RequestMapping("/api")
public class RecordController {
    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    /**
     * GET /api/records/{fileId}
     * Get all parsed records from a file grouped by file
     */
    @GetMapping("/records/fixed-files/{fileId}")
    public List<Record> getRecordListByFileId(@PathVariable String fileId) throws NotFoundException {
        ObjectId fileObjectId = new ObjectId(fileId);
        return recordService.getRecordListByFixedFile(fileObjectId);
    }

    /**
     * GET /api/records/spec-files/{specFileId}
     * Get all parsed records from a file grouped by type
     */
    @GetMapping("/records/spec-files/{specFileId}")
    public List<Record> getRecordListBySpecFileId(@PathVariable String specFileId) throws NotFoundException {
        ObjectId specFileObjectId = new ObjectId(specFileId);
        return recordService.getRecordListBySpecFile(specFileObjectId);
    }

    /**
     * GET /api/records/json/{fileID}
     * Download a JSON representation of all records from a file.
     */
    //TODO
}
