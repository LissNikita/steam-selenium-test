package org.steamTests.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.steamTests.models.GameData;
import org.steamTests.models.UserData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "gameData")
    public Object[][] getGameData() throws IOException {
        String filePath = "src/test/resources/test-data/gameData.json";
        List<GameData> gameDataList = readTestGameDataFromJson(filePath);

        Object[][] data = new Object[gameDataList.size()][1];
        for (int i = 0; i < gameDataList.size(); i++) {
            data[i][0] = gameDataList.get(i);
        }

        return data;
    }

    private List<GameData> readTestGameDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<List<GameData>>() {
            });
        }
    }

    @DataProvider(name = "userSuccessfulData")
    public Object[][] getUserSuccessfulData() throws IOException {
        String filePath = "src/test/resources/test-data/userSuccessfulData.json";
        List<UserData> userDataList = readTestUserDataFromJson(filePath);

        Object[][] data = new Object[userDataList.size()][1];
        for (int i = 0; i < userDataList.size(); i++) {
            data[i][0] = userDataList.get(i);
        }

        return data;
    }

    @DataProvider(name = "userUnsuccessfulData")
    public Object[][] getUserUnsuccessfulData() throws IOException {
        String filePath = "src/test/resources/test-data/userUnsuccessfulData.json";
        List<UserData> userDataList = readTestUserDataFromJson(filePath);

        Object[][] data = new Object[userDataList.size()][1];
        for (int i = 0; i < userDataList.size(); i++) {
            data[i][0] = userDataList.get(i);
        }

        return data;
    }

    private List<UserData> readTestUserDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<List<UserData>>() {
            });
        }
    }
}
