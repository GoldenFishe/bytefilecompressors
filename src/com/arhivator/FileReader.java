package com.arhivator;

import java.io.*;

public class FileReader {
    FileInputStream file;
    byte[] data;

    public byte[] getFile(String path) {
        try {
            file = new FileInputStream(path);
            data = file.readAllBytes();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        } finally {
            try {
                file.close();
            } catch (IOException err) {
                System.out.println(err.getMessage());
            }
        }
        return data;
    }
}
