package com.dp.decorator.example1;

public class FileDataSource implements DataSource{

    private String fileName;

    public FileDataSource(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void writeData(String data) {
        System.out.println("Data written to file");
    }

    @Override
    public String readData() {
        System.out.println("Data written to file");
        return "temp_data";
    }
}
