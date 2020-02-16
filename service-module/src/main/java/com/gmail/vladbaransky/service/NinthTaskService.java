package com.gmail.vladbaransky.service;

import com.gmail.vladbaransky.service.exception.QuantityNumbersException;

public interface NinthTaskService {
    int readAndReturnSum(String fileName) throws QuantityNumbersException;
}
