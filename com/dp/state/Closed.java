package com.dp.state;

public class Closed implements State {

    @Override
    public void open(Connection context) {
        System.out.println("Reopening Connection");
        context.setState(new Opened());
    }

    @Override
    public void close(Connection context) {
        System.out.println("Connection is already closed.");
    }

    @Override
    public void send(String data, Connection context) {
        System.out.println("Can't sent.. Connection closed");
    }
}
