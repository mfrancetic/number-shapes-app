package com.mfrancetic.numbershapesapp;

public class Number {

    public int numberValue;

    public boolean isTriangular() {
        double value = (Math.sqrt(8 * numberValue + 1) - 1) / 2;
        return value % 1 == 0;
    }

    public boolean isSquare() {
        int square = (int) Math.sqrt(numberValue);
        if (Math.pow(square, 2) == numberValue) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRectangular() {
        int root = (int) Math.sqrt(numberValue);
        if (root * (root +1) == numberValue) {
            return true;
        } else {
            return false;
        }
    }

}
