package com.arhivator;

import java.util.ArrayList;

public class Classificatory {
    byte[] bytes;
    byte[] descriptionByte;

    ArrayList<Byte> bytesList = new ArrayList<>();
    ArrayList<Integer> descriptionIndexList = new ArrayList<>();
    ArrayList<Byte> descriptionByteList = new ArrayList<>();

    public Classificatory(byte[] data) {
        this.bytes = data;
        for (byte bt : bytes) {
            bytesList.add(bt);
        }
    }

    public ArrayList<Byte> setRange() {
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
                    descriptionIndexList.add(currentIndex);
                    descriptionIndexList.add(nextIndex);
                    descriptionByteList.add(bytes[currentIndex]);
                    deleteSubArray(currentIndex, nextIndex);
                    currentIndex = nextIndex;                         // offset for correct next subRange
                } else {
                    currentIndex++;
                }
            } else {
                currentIndex++;
            }
        }
        return bytesList;
    }

    public byte[] getDescriptionByte() {
        int i = 0;
        for (Byte bt : descriptionByteList) {
            descriptionByte[i] = bt.byteValue();
            i++;
        }
        return descriptionByte;
    }

    public ArrayList<Integer> getDescriptionIndexList() {
        return descriptionIndexList;
    }

    private void deleteSubArray(int start, int end) {
        bytesList.subList(start, end).clear();
    }
}
