package com.dp.decorator.example1;

public abstract class BaseDecorator implements DataSource{

    private DataSource dataSource;

    public BaseDecorator(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void writeData(String data) {
        dataSource.writeData(data);
    }

    @Override
    public String readData() {
        return dataSource.readData();
    }
}
