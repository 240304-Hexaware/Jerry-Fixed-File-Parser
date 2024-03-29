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
    @MongoId(FieldType.OBJECT_ID)
    private String recordId;

    /**
     * Foreign key reference for the user associated with the record
     */
    @Field("userId")
    private String userId;

    /**
     * Foreign key reference for the specification file
     * that was used to generate the record
     */
    @Field("specFileId")
    private String specFileId;

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
     * @param userId id associated user who uploaded the fixed file
     * @param specFileId id associated with the spec file used to parse the fixed file
     * @param keys string array representing variable name
     * @param values string array representing variable data
     */
    public Record(String recordId, String userId, String specFileId,
                  String[] keys, String[] values) {
        this.recordId = recordId;
        this.userId = userId;
        this.specFileId = specFileId;
        this.keys = keys;
        this.values = values;
    }

    /**
     * Constructor with recordId generated
     *
     * @param userId id associated user who uploaded the fixed file
     * @param specFileId id associated with the spec file used to parse the fixed file
     * @param keys string array representing variable name
     * @param values string array representing variable data
     */
    public Record(String userId, String specFileId, String[] keys, String[] values) {
        this.userId = userId;
        this.specFileId = specFileId;
        this.keys = keys;
        this.values = values;
    }

    /**
     * @return Gets the value of recordId and returns recordId
     */
    public String getRecordId() {
        return recordId;
    }

    /**
     * Sets the recordId
     * You can use getRecordId() to get the value of recordId
     *
     * @param recordId
     */
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    /**
     * @return Gets the value of userId and returns userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     * You can use getUserId() to get the value of userId
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return Gets the value of specFileId and returns specFileId
     */
    public String getSpecFileId() {
        return specFileId;
    }

    /**
     * Sets the specFileId
     * You can use getSpecFileId() to get the value of specFileId
     *
     * @param specFileId
     */
    public void setSpecFileId(String specFileId) {
        this.specFileId = specFileId;
    }

    /**
     * @return Gets the value of keys and returns keys
     */
    public String[] getKeys() {
        return keys;
    }

    /**
     * Sets the keys
     * You can use getKeys() to get the value of keys
     *
     * @param keys
     */
    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    /**
     * @return Gets the value of values and returns values
     */
    public String[] getValues() {
        return values;
    }

    /**
     * Sets the values
     * You can use getValues() to get the value of values
     *
     * @param values
     */
    public void setValues(String[] values) {
        this.values = values;
    }
}