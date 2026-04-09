package utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonReader {

    public static List<Map<String, String>> getTestData(String fileName) {

        List<Map<String, String>> dataList = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();

            InputStreamReader reader = new InputStreamReader(
                    JsonReader.class.getClassLoader().getResourceAsStream(fileName)
            );

            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object obj : jsonArray) {
                dataList.add((Map<String, String>) obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
}