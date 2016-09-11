package Lesson4.Monitor;
import java.io.File;
import java.io.IOException;

public class Monitor {
	String file;
    String[] files;
	IFileEvent event;
	
	public Monitor(String file, IFileEvent event) {
		this.file = file;
		this.event = event;
	}

    public Monitor(String[] files, IFileEvent event) {
        this.files = files;
        this.event = event;
    }
	
	public void start() throws IOException {
		while (true) {
			File f = new File(file);
			
			if (f.exists() && f.isFile()) {
				if (event != null) {
                    event.onFileAdded(file);
                }
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			System.out.println("Waiting...");
		}
	}


	public void startList() throws IOException {
	    int cnt = files.length;
        File[] f = new File[files.length];

        for (int i = 0; i<files.length; i++) {
            f[i] = new File(files[i]);
        }

		while (true) {

		    for(int i = 0; i<files.length; i++) {
                if (files[i]!= null && f[i].exists() && f[i].isFile()) {
                    files[i] = null;
                    cnt--;
                }
            }

            if(cnt == 0) {
                if (event != null) {
                    event.onFileListAdded(f);
                }
                break;
            }

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {}

			System.out.println("Waiting...");
		}
	}

    public void startDir(String ext) throws IOException {
        File dir = new File(file);
        boolean isExt = false;
        File fAdd = new File("");

        while (true) {
            File[] listFiles = dir.listFiles();
            if(listFiles.length > 0) {
                for (File f: listFiles) {
                    if(f.isFile() && f.getName().endsWith(ext)) {
                        isExt = true;
                        fAdd = f;
                        break;
                    }
                }
            }

            if(isExt) {
                if (event != null) {
                    event.onFileExtAdded(fAdd, ext);
                }
                break;
            }

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {}

            System.out.println("Waiting...");
        }
    }
}