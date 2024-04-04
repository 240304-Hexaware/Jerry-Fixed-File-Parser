package com.revature.springserver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.Field;
import com.revature.springserver.model.SpecificationFile;
import com.revature.springserver.repository.SpecificationFileRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service class for managing business logic for Specification File
 */
@Service
public class SpecificationFileService {
    private SpecificationFileRepository specificationFileRepository;

    /**
     * Constructs a new SpecificationFileService with the provided SpecificationFileRepository
     *
     * @param specificationFileRepository The SpecificationFileRepository to be used for database operations
     */
    @Autowired
    public SpecificationFileService(SpecificationFileRepository specificationFileRepository) {
        this.specificationFileRepository = specificationFileRepository;
    }

    /**
     * Finds a specification file by their id
     * @param specFileId id associated with the specification file
     * @return the specification file
     * @throws NotFoundException if no specification associated with the id is found
     */
    public SpecificationFile findSpecificationFile(String specFileId) throws NotFoundException {
        return specificationFileRepository.findById(specFileId)
                .orElseThrow(() -> new NotFoundException("Query returned no result."));
    }


    /**
     * Creates a map associated with a specification file
     *
     * @param file The file object
     * @return map associated with a specification file
     * @throws IOException when we can't find the specification file
     */
    public static Map<String, Field> parseSpec(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Field> map = mapper.readValue(file, new TypeReference<Map<String, Field>>() {});

        Set<String> keySet = map.keySet();
        for(String s : keySet) {
            map.get(s).setName(s);
        }
        return map;
    }

    /**
     * Uploads and creates a new SpecificationFile as well as saving it to block storage
     *
     * @param userId id associated with the user who uploaded the file
     * @param file The file object
     * @return the newly created SpecificationFile
     * @throws IOException when file is not found
     */
    public SpecificationFile uploadSpecificationFile(String userId, MultipartFile file) throws IOException {
        // Save the file to the specified location
        String fileName = file.getOriginalFilename();
        String filePath = "./spring-server/src/main/resources/spec-files/" + fileName;
        System.out.println(System.getProperty("user.dir"));
        File savedFile = new File(filePath);
        try(OutputStream os = new FileOutputStream(savedFile)) {
            os.write(file.getBytes());
        }
        // Create new specification file object
        SpecificationFile specificationFile = new SpecificationFile(userId, filePath, fileName);

        // Save specification file to database
        return specificationFileRepository.save(specificationFile);
    }

    public List<SpecificationFile> getSpecificationFileListByUser(String userId) throws NotFoundException {
        return specificationFileRepository.findAllByUserId(userId)
                .orElseThrow(() -> new NotFoundException("No Specification File found associated with the User Id"));
    }

    public List<SpecificationFile> getAllSpecificationFiles(){
        return specificationFileRepository.findAll();
    }


}
