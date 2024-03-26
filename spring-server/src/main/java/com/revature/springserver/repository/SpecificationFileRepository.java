package com.revature.springserver.repository;

import com.revature.springserver.model.SpecificationFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *  Repository class dealing with the database interactions for SpecificationFile
 */
@Repository
public interface SpecificationFileRepository extends MongoRepository<SpecificationFile, ObjectId> {
}
