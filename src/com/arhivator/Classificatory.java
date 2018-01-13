package com.arhivator;

import java.util.ArrayList;

public class Classificatory {
    byte[] bytes;

    public Classificatory(byte[] data) {
        this.bytes = data;
    }

    public void setRange() {

        byte prevByte = bytes[0];
        byte currentByte = bytes[1];
        ArrayList<Byte> range = new ArrayList<>();

        for (int i = 0; i < bytes.length; i++) {
            if (i > 1) {
                prevByte = currentByte;
                currentByte = bytes[i];
            }
            if (prevByte == currentByte) {
                range.add(currentByte);
            }
        }
        System.out.print("range size: " + range.size());
    }
}
