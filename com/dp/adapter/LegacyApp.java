package com.dp.adapter;


/**
 * Client: Legacy App which expects LegacyReader(Target Interface)
 */
public class LegacyApp {

    private final LegacyFileReader reader;

    public LegacyApp(LegacyFileReader reader) {
        this.reader = reader;
    }

    public String readFile(String filePath) {
        return reader.readFile(filePath);
    }
}
