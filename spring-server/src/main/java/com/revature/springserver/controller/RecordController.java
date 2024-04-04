package com.revature.springserver.controller;

import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.Record;
import com.revature.springserver.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that defines REST endpoints and handles HTTP Requests for Record
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class RecordController {
    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    /**
     * GET /api/records/users/{userId}
     * Get all parsed records from a file grouped by user
     */
    @GetMapping("/records/users/{userId}")
    public List<Record> getRecordListByUserId(@PathVariable String userId) throws NotFoundException {
        return recordService.getRecordListByUser(userId);
    }

    /**
     * GET /api/records/spec-files/{specFileId}
     * Get all parsed records from a file grouped by type
     */
    @GetMapping("/records/spec-files/{specFileId}")
    public List<Record> getRecordListBySpecFileId(@PathVariable String specFileId) throws NotFoundException {
        return recordService.getRecordListBySpecFile(specFileId);
    }

    @GetMapping("/records")
    public List<Record> getAllRecords(){
        return recordService.getAllRecords();
    }
}
