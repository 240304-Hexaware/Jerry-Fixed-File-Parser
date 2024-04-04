package com.revature.springserver.repository;

import com.revature.springserver.model.SpecificationFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *  Repository class dealing with the database interactions for SpecificationFile
 */
@Repository
public interface SpecificationFileRepository extends MongoRepository<SpecificationFile, String> {
    /**
     * Retrieves all specification files that were uploaded by a specific user from database
     *
     * @param userId the id pertaining to the user
     * @return list of specification files that were uploaded by the user
     */
    Optional<List<SpecificationFile>> findAllByUserId(String userId);
}
