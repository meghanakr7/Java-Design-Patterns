import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiFileDownloaderRunnableCallable {
    static class FileDownloaderRunnable implements Runnable {
        private String fileName;
        private String fileURL;

        public FileDownloaderRunnable(String fileName, String fileURL) {
            this.fileName = fileName;
            this.fileURL = fileURL;
        }

        @Override
        public void run() {
            try(InputStream in = new BufferedInputStream(new URL(fileURL).openStream());
            FileOutputStream out = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, count);
            }
            System.out.println("✅ Runnable: Downloaded " + fileName);
            } catch (IOException e) {
                System.out.println("❌ Runnable failed: " + fileName + " → " + e.getMessage());
            }
        }
    }

        static class FileDownloaderCallable implements Callable<String> {
        private String url;
        private String fileName;

        public FileDownloaderCallable(String url, String fileName) {
            this.url = url;
            this.fileName = fileName;
        }

        @Override
        public String call() throws Exception {
            long start = System.currentTimeMillis();
            try (InputStream in = new BufferedInputStream(new URL(url).openStream());
                 FileOutputStream out = new FileOutputStream(fileName)) {

                byte[] buffer = new byte[1024];
                int count;
                while ((count = in.read(buffer, 0, 1024)) != -1) {
                    out.write(buffer, 0, count);
                }
                long time = System.currentTimeMillis() - start;
                return "✅ Callable: Downloaded " + fileName + " in " + time + " ms";
            } catch (IOException e) {
                return "❌ Callable failed: " + fileName + " → " + e.getMessage();
            }
        }

}

public static void main(String[] args) throws  InterruptedException , ExecutionException{
    Map<String, String> fileMap = new LinkedHashMap<>();
        fileMap.put("https://file-examples.com/wp-content/uploads/2017/10/file-example_PDF_1MB.pdf", "file1.pdf");
        fileMap.put("https://file-examples.com/wp-content/uploads/2017/11/file_example_MP3_1MG.mp3", "audio1.mp3");

    // 🔸 Use Runnable
    for (Map.Entry<String, String> entry : fileMap.entrySet()) {
        Thread t = new Thread(new FileDownloaderRunnable(entry.getKey(), entry.getValue()));
        t.start();
    }

    ExecutorService executor = Executors.newFixedThreadPool(3);
    List<Future<String>> results = new ArrayList<>();
    for (Map.Entry<String, String> entry : fileMap.entrySet()) {
        Callable<String> task = new FileDownloaderCallable(entry.getKey(), "callable_"+entry.getValue());
        results.add(executor.submit(task));
    }
    for (Future<String> result : results) {
            System.out.println(result.get());
        }


    }
    
}
