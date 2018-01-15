package com.arhivator;

import java.util.ArrayList;

public class Classificatory {
    byte[] bytes;
    ArrayList<Byte> bytesList = new ArrayList<>();

    public Classificatory(byte[] data) {
        this.bytes = data;
        for(byte bt: bytes) {
            bytesList.add(bt);
        }
    }

    public void setRange() {
        int currentIndex = 0;
        int nextIndex;

        // cycle for find range of same values in bytes array
        while (currentIndex < bytes.length) {
            nextIndex = currentIndex + 1;                             // define next index
            if (nextIndex < bytes.length) {                           // check for outrange index in bytes array
                if (bytes[currentIndex] == bytes[nextIndex]) {
                    while (bytes[currentIndex] == bytes[nextIndex]) { // cycle for find same value
                        nextIndex++;
                    }
                    replaceSubArray(currentIndex,nextIndex);
                    currentIndex = nextIndex;                         // offset for correct next subRange
                } else {
                    currentIndex++;
                }
            } else {
                currentIndex++;
            }
        }
    }
    private void replaceSubArray (int start, int end) {
        bytesList.subList(start,end).clear();
        System.out.println(start + " " + end);
    }
}
