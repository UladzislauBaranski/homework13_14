package com.gmail.vladbaransky.service;

import com.gmail.vladbaransky.service.exception.QuantityNumbersException;

public interface SeventhTaskService {
    int add(String numbers) throws QuantityNumbersException;
}
