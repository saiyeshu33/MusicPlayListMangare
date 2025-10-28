package application.controllers;

import application.models.Song;
import application.utils.FileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

public class PlaylistController {

    @FXML private TextField titleField, artistField, albumField, durationField, searchField;
    @FXML private TableView<Song> songTable;
    @FXML private TableColumn<Song, String> titleCol, artistCol, albumCol, durationCol;

    private ObservableList<Song> songList;

    @FXML
    public void initialize() {
        List<Song> loadedSongs = FileManager.loadSongs();
        songList = FXCollections.observableArrayList(loadedSongs);
        songTable.setItems(songList);
    }

    @FXML
    public void addSong() {
        Song song = new Song(
                titleField.getText(),
                artistField.getText(),
                albumField.getText(),
                durationField.getText()
        );
        songList.add(song);
        FileManager.saveSongs(songList);
        clearFields();
    }

    @FXML
    public void deleteSong() {
        Song selected = songTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            songList.remove(selected);
            FileManager.saveSongs(songList);
        }
    }

    @FXML
    public void searchSong() {
        String keyword = searchField.getText().toLowerCase();
        List<Song> filtered = FileManager.loadSongs().stream()
                .filter(s -> s.getTitle().toLowerCase().contains(keyword)
                        || s.getArtist().toLowerCase().contains(keyword))
                .toList();
        songList.setAll(filtered);
    }

    private void clearFields() {
        titleField.clear();
        artistField.clear();
        albumField.clear();
        durationField.clear();
    }
}
