package com.dp.adapter;


/**
 * Adapter pattern used to allow to incompatible objects to work together. The object join the two
 * object is called adapter.
 * <p>
 * Adapter
 */
public class ModernFileReaderAdapter implements LegacyFileReader {

    private final ModernFileReader fileReader;

    public ModernFileReaderAdapter(ModernFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public String readFile(String filePath) {
        try {
            return fileReader.readContent(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
