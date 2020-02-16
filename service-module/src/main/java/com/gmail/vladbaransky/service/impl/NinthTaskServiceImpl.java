package com.gmail.vladbaransky.service.impl;

import com.gmail.vladbaransky.repository.EighthTaskRepository;
import com.gmail.vladbaransky.service.NinthTaskService;
import com.gmail.vladbaransky.service.SeventhTaskService;
import com.gmail.vladbaransky.service.exception.QuantityNumbersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ninthTaskServiceImpl")
public class NinthTaskServiceImpl implements NinthTaskService {
    @Autowired
    private EighthTaskRepository eighthTaskRepository;
    @Autowired
    private SeventhTaskService seventhTaskService;

    @Override
    public int readAndReturnSum(String fileName) throws QuantityNumbersException {
        List<String> stringList = eighthTaskRepository.getCollectionFromFile(fileName);
        int sumAllNumbers = 0;
        for (String s : stringList) {
            sumAllNumbers += seventhTaskService.add(s);
        }
        return sumAllNumbers;
    }
}
