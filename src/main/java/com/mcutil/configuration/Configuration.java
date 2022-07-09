package com.mcutil.configuration;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private final Map<String, String> configs;

    private final File file;

    public Configuration(final File file) {
        this.configs = new HashMap<>();
        this.file = file;
    }

    public void setConfig(String config, String value) {
        this.getConfigs().put(config, value);
    }

    public void saveConfiguration() {
        try {
            final Writer writer = new FileWriter(this.getFile());
            this.getConfigs().forEach((s, s2) -> {
                try {
                    writer.write(s + "=" + s2 + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getConfigs() {
        return configs;
    }

    public File getFile() {
        return file;
    }
}
