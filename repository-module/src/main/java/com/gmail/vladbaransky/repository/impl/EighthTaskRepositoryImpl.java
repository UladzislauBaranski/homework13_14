package com.gmail.vladbaransky.repository.impl;

import com.gmail.vladbaransky.repository.EighthTaskRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;


@Repository(value = "eighthTaskRepositoryImpl")
public class EighthTaskRepositoryImpl implements EighthTaskRepository {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public List<String> getCollectionFromFile(String fileName) {
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ex) {
            logger.info("Cannot read file" + ex.getMessage());
        }
        return lines;
    }
}
