package configs;

import com.mcutil.configuration.Configuration;
import com.mcutil.configuration.ConfigurationReader;

import java.io.File;
import java.io.IOException;

public class TestConfig {

    public TestConfig() throws IOException, InterruptedException {
        final File file = new File("test.conf");
        if (!file.exists()) {
            file.createNewFile();
        }

        final Configuration configuration = new Configuration(file);
        configuration.setConfig("test", "value");
        configuration.setConfig("test3", "value2");
        configuration.saveConfiguration();
        Thread.sleep(1000);
        System.out.println(new ConfigurationReader(file).get());
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new TestConfig();
    }

}
