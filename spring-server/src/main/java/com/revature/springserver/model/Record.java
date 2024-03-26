package com.revature.springserver.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Class that models a record parsed from a fixed file
 */
@Document("record")
public class Record {
    /**
     * An id for the record
     */
    @Field("_id")
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId recordId;

    /**
     * Foreign key reference for the fixed file
     * the record was from
     */
    @Field("fixedFileId")
    private ObjectId fixedFileId;

    /**
     * Foreign key reference for the specification file
     * that was used to generate the record
     */
    @Field("specFileId")
    private ObjectId specFileId;

    /**
     * keys and values representing dictionary using 2 string arrays
     * used to store data of record
     */
    @Field("keys")
    private String[] keys;
    @Field("values")
    private String[] values;

    /**
     * No arg constructor
     */
    public Record() {
    }

    /**
     * Constructor with all args
     *
     * @param recordId id associated with the created record
     * @param fixedFileId id associated with the source of the record data
     * @param specFileId id associated with the spec file used to parse the fixed file
     * @param keys string array representing variable name
     * @param values string array representing variable data
     */
    public Record(ObjectId recordId, ObjectId fixedFileId, ObjectId specFileId,
                  String[] keys, String[] values) {
        this.recordId = recordId;
        this.fixedFileId = fixedFileId;
        this.specFileId = specFileId;
        this.keys = keys;
        this.values = values;
    }

    /**
     * Constructor with recordId generated
     *
     * @param fixedFileId id associated with the source of the record data
     * @param specFileId id associated with the spec file used to parse the fixed file
     * @param keys string array representing variable name
     * @param values string array representing variable data
     */
    public Record(ObjectId fixedFileId, ObjectId specFileId, String[] keys, String[] values) {
        this.fixedFileId = fixedFileId;
        this.specFileId = specFileId;
        this.keys = keys;
        this.values = values;
    }
}