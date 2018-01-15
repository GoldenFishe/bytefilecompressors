package com.arhivator;

import java.util.ArrayList;
import java.io.*;

public class FileSaver {
    ArrayList<Byte> byteArrayList;

    public FileSaver(ArrayList<Byte> bytes) {
        this.byteArrayList = bytes;
    }

    public void saveFile(String pathSave) {
        byte[] bytes = new byte[byteArrayList.size()];
        int i = 0;
        for (Byte bt : byteArrayList) {
            bytes[i] = bt.byteValue();
            i++;
        }
        try (FileOutputStream file = new FileOutputStream(pathSave)) {
            file.write(bytes);
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
