package com.arhivator;

public class Main {
    public static void main(String[] args) {
        String path = "C:/JAVA/arhivator/src/test_data/test.jpg";
        FileReader fileReader = new FileReader();
        byte[] data = fileReader.getFile(path);
        Classificatory classificatory = new Classificatory(data);
        classificatory.setRange();
    }
}
