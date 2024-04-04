package com.revature.springserver.service;

import com.revature.springserver.exception.NotFoundException;
import com.revature.springserver.model.Field;
import com.revature.springserver.model.FixedFile;
import com.revature.springserver.repository.FixedFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service class for managing business logic for Fixed File
 */
@Service
public class FixedFileService {
    private FixedFileRepository fixedFileRepository;

    /**
     * Constructs a new FixedFileService with the provided SpecificationFileRepository
     *
     * @param fixedFileRepository The FixedFileRepository to be used for database operations
     */
    @Autowired
    public FixedFileService(FixedFileRepository fixedFileRepository) {
        this.fixedFileRepository = fixedFileRepository;
    }

    /**
     * Retrieves all fixed files that were uploaded by a specific user
     *
     * @param userId the id pertaining to the user
     * @return list of fixed files that were uploaded by the user
     * @throws NotFoundException if not fixed file was associated with the user id
     */
    public List<FixedFile> getFixedFileListByUser(String userId) throws NotFoundException {
        return fixedFileRepository.findAllByUserId(userId)
                .orElseThrow(() -> new NotFoundException("No Fixed File was found associated with the User Id"));
    }

    public List<FixedFile> getAllFixedFiles(){
        return fixedFileRepository.findAll();
    }


    /**
     * Uploads and creates a new FixedFile as well as saving it to block storage
     *
     * @param userId id associated with the user who uploaded the file
     * @param file The file object
     * @return the newly created FixedFile
     * @throws IOException when file is not found
     */
    public FixedFile uploadFixedFile(String userId, MultipartFile file) throws IOException {
        // Save the file to the specified location
        String fileName = file.getOriginalFilename();
        String filePath = "./spring-server/src/main/resources/fixed-files/" + fileName;
        File savedFile = new File(filePath);
        try(OutputStream os = new FileOutputStream(savedFile)) {
            os.write(file.getBytes());
        }
        // Create new fixed file object
        FixedFile fixedFile = new FixedFile(userId, filePath, fileName);

        // Save fixed file to database
        return fixedFileRepository.save(fixedFile);
    }

    /**
     * This reads the entire fixed file at once with readAllBytes.
     *
     * @return String representing all the data from the file
     * @throws IOException if the file does not exist
     */
    public String readAllBytesFromFile(FixedFile fixedFile) throws IOException {
        File file = new File(fixedFile.getFilePath());
        return new String(Files.readAllBytes(file.toPath())).intern();
    }

    /**
     * This will take the parsed string fields from a flat file and a spec map
     * in order to create a list of strings, each representing one field value from the flat file
     *
     * @param data the parsed string data
     * @param map  a map of tokens representing fields in the fixed file
     * @return the parsed value strings of
     * @throws IOException if the file does not exist
     */
    public ArrayList<ArrayList<String>> readStringFields(String data, Map<String, Field> map) throws IOException {
        ArrayList<ArrayList<String>> stringFields = new ArrayList<ArrayList<String>>();
        Set<String> fields = map.keySet();
        int pos = 0;
        int length = data.length();
        boolean endOfFile = false;
        // just need to check if we are near the end of the string and while loop
        while(pos < length){
            ArrayList<String> nameList = new ArrayList<String>();
            ArrayList<String> fieldList = new ArrayList<String>();
            for(String fieldName : fields) {
                Field field = map.get(fieldName);
                if(pos + field.getWidth() + 1 > length){
                    endOfFile = true;
                    break;
                }
                String fieldValue = data.substring(pos, pos + field.getWidth()+1).trim();
                nameList.add(fieldName);
                fieldList.add(fieldValue);
                System.out.println(nameList);
                System.out.println(fieldList);
                pos += field.getWidth() + 1;
            }
            if(endOfFile){
                break;
            }
            stringFields.add(nameList);
            stringFields.add(fieldList);
        }
        //return new String[][]{nameList.toArray(new String[0]), fieldList.toArray(new String[0])};
        return stringFields;
    }
}
