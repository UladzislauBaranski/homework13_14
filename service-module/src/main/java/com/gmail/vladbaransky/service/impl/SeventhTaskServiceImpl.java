package com.gmail.vladbaransky.service.impl;

import com.gmail.vladbaransky.service.SeventhTaskService;
import com.gmail.vladbaransky.service.exception.QuantityNumbersException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service(value = "seventhTaskServiceImpl")
public class SeventhTaskServiceImpl implements SeventhTaskService {

    @Override
    public int add(String numbers) throws QuantityNumbersException {
        String regex = "\\d+";
        return getSumFromString(regex, numbers);
    }

    private int getSumFromString(String regex, String numbers) throws QuantityNumbersException {
        int sumNumbers = 0;
        int count = 0;
        Pattern regexp = Pattern.compile(regex);
        Matcher matcher = regexp.matcher(numbers);
        while (matcher.find()) {
            count++;
            String string = matcher.group();
            sumNumbers += Integer.parseInt(string);
        }
        return checkQuantityNumbers(sumNumbers, count);
    }

    private int checkQuantityNumbers(int sumNumbers, int count) throws QuantityNumbersException {
        int maxSize = 2;
        if (count <= maxSize) {
            return sumNumbers;
        } else {
            throw new QuantityNumbersException("Number of numbers in the line of a file exceeds number specified:" + maxSize);
        }
    }
}
