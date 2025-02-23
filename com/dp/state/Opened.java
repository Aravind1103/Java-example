package com.dp.state;

public class Opened implements State {
    @Override
    public void open(Connection context) {
        System.out.println("Connection Opened");
    }

    @Override
    public void close(Connection context) {
        System.out.println("Can't close since it is not opened");
        context.setState(new Closed());
    }

    @Override
    public void send(String data, Connection context) {
        System.out.println("Sending data...");
    }
}
