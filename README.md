# 🎵 Music Playlist Manager

A simple **JavaFX** application that allows users to create, search, and manage their personal music playlists.  
Users can add songs (title, artist, album, duration), search for specific songs, and delete entries dynamically.

---

## 🚀 Features

- Add new songs with details: **Title**, **Artist**, **Album**, and **Duration**
- Display all songs in a **TableView**
- Search songs by title or artist
- Delete selected songs
- Data persistence using local file storage (via `FileManager` utility)
- Built with JavaFX for a clean and interactive UI

---

## 🧩 Project Structure
MusicPlayListManager/
│
├── .idea/ # IntelliJ project configuration
├── out/ # Compiled files
├── src/
│ └── application/
│ ├── controllers/
│ │ └── PlayListController.java
│ ├── models/
│ │ ├── Playlist.java
│ │ └── Song.java
│ ├── utils/
│ │ └── FileManager.java
│ ├── views/
│ │ └── PlaylistView.fxml
│ └── Main.java
│
├── MusicPlayListManager.iml
├── .gitignore
└── README.md

---

## ⚙️ Requirements

- **Java JDK 17** or higher (OpenJDK 25 works fine)
- **JavaFX SDK 25.0.1** or compatible
- IDE: **IntelliJ IDEA** (recommended)

---

## 🧠 Setup Instructions

### Step 1: Download JavaFX  
Get the JavaFX SDK from [https://openjfx.io/](https://openjfx.io/)  
Extract it to a known location (for example: `C:\javafx-sdk-25.0.1`)

---

### Step 2: Configure JavaFX in IntelliJ

1. Go to **File → Project Structure → Libraries**  
2. Click **+ → Java →** and select the folder  
   `C:\javafx-sdk-25.0.1\lib`
3. Then, open **Run → Edit Configurations...**
4. Under **VM options**, add this line:
--module-path "C:\javafx-sdk-25.0.1\lib" --add-modules javafx.controls,javafx.fxml

---

### Step 3: Check FXML Controller Link
In `PlaylistView.fxml`, ensure the controller is properly linked:
```xml
fx:controller="application.controllers.PlayListController"


