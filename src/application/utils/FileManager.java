package application.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import application.models.Song;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "songs.json";

    public static void saveSongs(List<Song> songs) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            Gson gson = new Gson();
            gson.toJson(songs, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Song> loadSongs() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Song>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
