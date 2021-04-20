package com.sample.test.demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class Configuration {

    private static final String CONFIG_FILE_NAME = "config.properties";
    private Properties configProperties;

    public Configuration() {
        loadProperties();
    }

    private void loadProperties() {
        configProperties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assertTrue(classLoader != null);
        InputStream inputStream = classLoader.getResourceAsStream(CONFIG_FILE_NAME);
        try {
            configProperties.load(inputStream);
        } catch (final IOException e) {
        }
    }

        public static Map<String, String> HashMapFromTextFile()
        {
            final String filePath = "src/test/resources/files/locators.txt";

            Map<String, String> map
                    = new HashMap<String, String>();
            BufferedReader br = null;

            try {

                // create file object
                File file = new File(filePath);

                // create BufferedReader object from the File
                br = new BufferedReader(new FileReader(file));

                String line = null;

                // read file line by line
                while ((line = br.readLine()) != null) {

                    // split the line by :
                    String[] parts = line.split(":");

                    // first part is name, second is number
                    String name = parts[0].trim();
                    String number = parts[1].trim();

                    // put name, number in HashMap if they are
                    // not empty
                    if (!name.equals("") && !number.equals(""))
                        map.put(name, number);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {

                // Always close the BufferedReader
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch (Exception e) {
                    };
                }
            }
            return map;
        }

    public String getBrowser() {
        return getProperty("browser");
    }

    public String getPlatform() {
        return getProperty("platform");
    }

    public String getUrl() {
        return getProperty("url");
    }
    public String getProperty(String propertyName) {
        return configProperties.getProperty(propertyName);
    }

    public static Properties readDataFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
