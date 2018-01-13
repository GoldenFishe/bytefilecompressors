package com.arhivator;

import java.util.ArrayList;

public class Classificatory {
    byte[] bytes;

    public Classificatory(byte[] data) {
        this.bytes = data;
    }

    public void setRange() {
        ArrayList<Byte[]> range = new ArrayList<>();                  // main range
        ArrayList<Byte> subRange = new ArrayList<>();                 // subrange in range
        int currentIndex = 0;
        int nextIndex;

        // cycle for find range of same values in bytes array
        while (currentIndex < bytes.length) {
            nextIndex = currentIndex + 1;                             // define next index
            if (nextIndex < bytes.length) {                           // check for outrange index in bytes array
                if (bytes[currentIndex] == bytes[nextIndex]) {
                    subRange.add(bytes[currentIndex]);
                    while (bytes[currentIndex] == bytes[nextIndex]) { // cycle for find same value
                        subRange.add(bytes[nextIndex]);
                        nextIndex++;
                    }
                    Byte[] inRange = new Byte[subRange.size()];       // create array for add in range. size array = size list
                    subRange.toArray(inRange);                        // make array from list subRange
                    range.add(inRange);                               // add array in range
                    subRange.clear();                                 // clear list for next cycle
                    currentIndex = nextIndex;                         // offset for correct next subRange
                } else {
                    currentIndex++;
                }
            } else {
                currentIndex++;
            }
        }
        System.out.println("range size: " + range.size());
    }
}
