
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MultiFileDownloader {
    static class Downloader extends Thread {

        private String fileName;
        private String fileURL;

        public Downloader(String fileName, String fileURL) {
            this.fileName = fileName;
            this.fileURL = fileURL;
        }

        @Override
        public void run() {
            System.out.println("Starting Download" + fileName);
            try(BufferedInputStream in  = new BufferedInputStream(new URL(fileURL).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = in.read(buffer, 0, 1024))!=-1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }   

                    System.out.println("Download Complete " + fileName);
                 } catch(IOException e) {
                    System.out.println("IO exception for this "  + fileName);
                 }
        }

    }

    public static void main(String []args) {
        Map<String, String> filesToDownload = new LinkedHashMap<>();
        filesToDownload.put(
                "https://github.com/lighthousand/books/blob/master/the-pragmatic-programmer.pdf",
                "Pragmatic Programmer.pdf");
        filesToDownload.put(
                "https://github.com/ohsusannamarie/Collection-of-Work-Life-related-eBooks/blob/main/The%20Let%20Them%20Theory%20by%20Mel%20Robbins.pdf",
                "Let Them.pdf");
        filesToDownload.put(
                "http://livre2.com/LIVREE/E1/E00100 2.pdf",
                "5 sec.pdf");
        
        List<Thread> threads  = new ArrayList<>();

        for(Map.Entry<String, String> entry : filesToDownload.entrySet()) {
            Downloader downloader = new Downloader(entry.getKey(), entry.getValue());
            threads.add(downloader);
            downloader.start();
        }

        for(Thread t: threads) {
            try {
                t.join();
            } catch(InterruptedException e) {
                System.out.println("Exception " + e.getMessage());
            }
        }

        System.out.print("all downloads finished");
    }
}
