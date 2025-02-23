package com.dp.adapter;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Adaptee
 */
public class ModernFileReader {

    public String readContent(String filePath) throws Exception {
        return Files.readString(Paths.get(filePath));
    }
}
