package com.dp.decorator.example1;

public class CompressionDecorator extends BaseDecorator{

    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        // 1. Compress passed data.
        // 2. Pass compressed data to the wrappee's writeData
        // method.
        System.out.println("Compressing data");
        writeData(data);
    }

    @Override
    public String readData() {
        // 1. Get data from the wrappee's readData method.
        // 2. Try to decompress it if it's compressed.
        // 3. Return the result.
        readData();
        System.out.println("Decompressing data");
        return "temp_data";
    }
}
