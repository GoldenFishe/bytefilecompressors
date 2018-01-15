package com.arhivator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String pathGet = "C:/java/arhivator/src/test_data/test_txt.txt";
        String pathSave = "C:/java/arhivator/src/test_data/test_saver.txt";

        FileReader fileReader = new FileReader();
        byte[] data = fileReader.getFile(pathGet);

        Classificatory classificatory = new Classificatory(data);
        ArrayList<Byte> byteArrayList = classificatory.setRange();

        FileSaver fileSaver = new FileSaver(byteArrayList);
        fileSaver.saveFile(pathSave);
    }
}
