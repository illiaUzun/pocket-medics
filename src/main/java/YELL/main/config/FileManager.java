package YELL.main.config;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private String path;
    private FileWriter fw;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileManager(String path) {
        this.path = path;
    }

    public void addToFile(String str) {
        try {
            fw = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
