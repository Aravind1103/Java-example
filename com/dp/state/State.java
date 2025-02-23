package com.dp.state;



/**
 * State pattern let objects change its behaviour based on the internal state changes.
 * */
public interface State {

    void open(Connection context);

    void close(Connection context);

    void send(String data, Connection context);
}
