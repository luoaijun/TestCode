package com.luoaijun.java.common.utis;

import java.io.*;
import java.util.Properties;

public class FileUtils {
    public static Properties propertiesLoad(String propertiesName) {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String fileLoad(String propertiesName) {
        File file;
        file = new File(this.getClass().getClassLoader().getResource(propertiesName).getPath());
        String result = "";
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String lineStr = "";
            while (true) {
                if (!((lineStr = bufferedReader.readLine()) != null)) break;
                result = result + lineStr;
            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        fileUtils.fileLoad("cityinfo.json");
    }

}
