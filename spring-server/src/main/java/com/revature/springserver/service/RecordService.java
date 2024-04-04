package com.revature.springserver.service;

import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.Record;
import com.revature.springserver.repository.RecordRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing business logic for Record
 */
@Service
public class RecordService {
    private RecordRepository recordRepository;

    /**
     * Construct a new RecordService with the provided RecordRepository
     *
     * @param recordRepository the RecordRepository to be used for database operations
     */
    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    /**
     * Retrieves a list of all the records that came from a user
     *
     * @param userId the id associated with the user
     * @return list of records
     * @throws NotFoundException if no record associated with the user id was found
     */
    public List<Record> getRecordListByUser(String userId) throws NotFoundException {
        return recordRepository.findAllByUserId(userId)
                .orElseThrow(() -> new NotFoundException("No Record was found associated with the user id"));
    }

    /**
     * Retrieves a list of all the records that were parsed from a specific spec file
     *
     * @param specFileId the id of the spec file that was used to parse the records
     * @return list of records
     * @throws NotFoundException if no record associated with the spec file id
     */
    public List<Record> getRecordListBySpecFile(String specFileId) throws NotFoundException {
        return recordRepository.findAllBySpecFileId(specFileId)
                .orElseThrow(() -> new NotFoundException("No Record was found associated with the fixed file id"));
    }

    /**
     * Adds and creates a new Record
     *
     * @param userId the id associated with the person who uploaded the fixed file
     * @param specFileId the id of the spec file that was used to parse the records
     * @param keys string array representing variable name
     * @param values string array representing variable data
     * @return newly created Record
     */
    public Record addRecord(String userId, String specFileId, String[] keys, String[] values){
        // create new Record and save to database
        return recordRepository.save(new Record(userId, specFileId, keys, values));
    }

    public List<Record> getAllRecords(){
        List<Record> recordList = recordRepository.findAll();
        return recordList;
    }
}

