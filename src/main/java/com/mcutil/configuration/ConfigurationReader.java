package com.mcutil.configuration;

import java.io.*;
import java.util.HashMap;
public class ConfigurationReader {

    private final File file;

    public HashMap<String, String> get() {
        HashMap<String, String> toReturn = new HashMap<>();
        try {
            String line;
            final BufferedReader reader = new BufferedReader(new FileReader(this.getFile()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] splitter = line.split("=");
                toReturn.put(splitter[0], splitter[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public ConfigurationReader(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
