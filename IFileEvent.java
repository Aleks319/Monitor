package Lesson4.Monitor;

import java.io.File;
import java.io.IOException;

public interface IFileEvent {
	void onFileAdded(String s) throws IOException;
	void onFileListAdded(File[] f) throws IOException;
    void onFileExtAdded(File f, String ext) throws IOException;
}
