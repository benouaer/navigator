package com.yoti.roomba.navigator.model;

public class Position {

    private int xCoordinate;
    private int yCoordinate;

    public Position() {}

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }
        return xCoordinate == ((Position)obj).xCoordinate && yCoordinate == ((Position)obj).yCoordinate;
    }
}
