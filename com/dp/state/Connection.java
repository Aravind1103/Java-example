package com.dp.state;

public class Connection {
    private State state;

    public Connection() {
        this.state = new Closed(); // Initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void open() {
        state.open(this);
    }

    public void close() {
        state.close(this);
    }

    public void send(String data) {
        state.send(data, this);
    }
}
