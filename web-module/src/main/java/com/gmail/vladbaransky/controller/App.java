package com.gmail.vladbaransky.controller;

import com.gmail.vladbaransky.service.NinthTaskService;
import com.gmail.vladbaransky.config.AppConfig;
import com.gmail.vladbaransky.controller.constant.FilePathConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.lang.invoke.MethodHandles;

@Controller
public class App {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        FilePathConstant filePathConstant = ctx.getBean(FilePathConstant.class);
        String fileName = filePathConstant.getFilePath();
        NinthTaskService ninthTaskService = ctx.getBean(NinthTaskService.class);
        try {
            int sumAllNumbers = ninthTaskService.readAndReturnSum(fileName);
            logger.info("Sum all numbers from file:" + sumAllNumbers);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}


