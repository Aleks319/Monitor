package Lesson4.Monitor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class FileEvent implements IFileEvent {
	@Override
	public void onFileAdded(String s) throws IOException {
        File f = new File(s);
        BasicFileAttributes bfa = Files.readAttributes(f.toPath(), BasicFileAttributes.class);

        System.out.println("File added: " + s);
        System.out.println("Date of creation: " + (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.creationTime().to(MILLISECONDS))));
		System.out.println("Date of last modification: " +(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.lastModifiedTime().to(MILLISECONDS))));

	}

    @Override
    public void onFileListAdded(File[] f) throws IOException {

        System.out.println("All files added:");
        for(File fl : f) {
            BasicFileAttributes bfa = Files.readAttributes(fl.toPath(), BasicFileAttributes.class);
            System.out.println("File " + fl.getName() + " :");
            System.out.println("Date of creation: " + (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.creationTime().to(MILLISECONDS))));
            System.out.println("Date of last modification: " +(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.lastModifiedTime().to(MILLISECONDS))));
        }
    }

    @Override
    public void onFileExtAdded(File f, String ext) throws IOException {

        System.out.println("The file with the extension \"" + ext + "\" is added in directory: " + f.getParentFile());
            BasicFileAttributes bfa = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
            System.out.println("File " + f.getName() + " :");
            System.out.println("Date of creation: " + (new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.creationTime().to(MILLISECONDS))));
            System.out.println("Date of last modification: " +(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SS").format(bfa.lastModifiedTime().to(MILLISECONDS))));

    }
}