package com.dp.decorator.example1;

public class EncryptionDecorator extends BaseDecorator{

    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) {
        // 1. Encrypt passed data.
        // 2. Pass encrypted data to the wrappee's writeData
        // method.
        System.out.println("Encrypting data");
        writeData(data);
    }

    @Override
    public String readData() {
        // 1. Get data from the wrappee's readData method.
        // 2. Try to decrypt it if it's encrypted.
        // 3. Return the result.
        readData();
        System.out.println("Decrypting data");
        return "temp_data";
    }

}
