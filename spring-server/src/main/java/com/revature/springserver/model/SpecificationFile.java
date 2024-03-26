package com.revature.springserver.model;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Class that models a specification file
 */
@Document("specification_file")
public class SpecificationFile {
    /**
     * An id for the specification file
     */
    @Field("_id")
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId specFileId;

    /**
     * An id representing the user who uploaded the file
     */
    @Field("userId")
    private ObjectId userId;

    /**
     * A string which represents the file path
     */
    @Field("file_path")
    private String filePath;

    /**
     * A string which represent the name of the file
     */
    @Field("name")
    private String name;

    /**
     * Default no arg constructor
     */
    public SpecificationFile() {
    }

    /**
     * Constructor with all the args
     *
     * @param specFileId An id associated with the specification file
     * @param userId An id representing the user who uploaded the file
     * @param filePath A string which represents the file path
     * @param name A string which represents the file path
     */
    public SpecificationFile(ObjectId specFileId, ObjectId userId, String filePath, String name) {
        this.specFileId = specFileId;
        this.userId = userId;
        this.filePath = filePath;
        this.name = name;
    }

    /**
     * Constructor with spec file id and file path
     *
     * @param userId An id representing the user who uploaded the file
     * @param filePath A string which represents the file path
     * @param name A string which represents the file path
     */
    public SpecificationFile(ObjectId userId, String filePath, String name){
        this.userId = userId;
        this.filePath = filePath;
        this.name = name;
    }

    /**
     * @return Gets the value of specFileId and returns specFileId
     */
    public ObjectId getSpecFileId() {
        return specFileId;
    }

    /**
     * Sets the specFileId
     * You can use getSpecFileId() to get the value of specFileId
     *
     * @param specFileId An id for the specification file
     */
    public void setSpecFileId(ObjectId specFileId) {
        this.specFileId = specFileId;
    }

    /**
     * @return Gets the value of userId and returns userId
     */
    public ObjectId getUserId() {
        return userId;
    }

    /**
     * Sets the userId
     * You can use getUserId() to get the value of userId
     *
     * @param userId An id representing the user who uploaded the file
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * @return Gets the value of filePath and returns filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the filePath
     * You can use getFilePath() to get the value of filePath
     *
     * @param filePath A string which represents the file path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return Gets the value of name and returns name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * You can use getName() to get the value of name
     *
     * @param name A string which represent the name of the file
     */
    public void setName(String name) {
        this.name = name;
    }
}
