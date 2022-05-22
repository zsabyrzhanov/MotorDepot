package com.company;

import java.io.FileReader;
import java.io.IOException;

import static com.company.Main.WRITE_PATH;

public class Truck {
    private int id;
    private String truckName;
    private String driver;
    private State State;


    public Truck(int id, String truckName, String driver, State State) {
        this.id = id;
        this.truckName = truckName;
        this.driver = driver;
        this.State = State;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String gettruckName() {
        return truckName;
    }

    public void settruckName(String truckName) {
        this.truckName = truckName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return State;
    }

    public void setState(State State) {
        this.State = State;

    }


    @Override
    public String toString() {
        return id + "  |" + truckName + "     |" + State + "      |" + driver;

    }

}

enum State {
    BASE, ROUTE, REPAIR


}

