package proxy.virtual;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;

public class LibraryLoaderProxy implements LibraryLoader {
  private volatile URI pathToBook = null;
  private final URI prevPath = Files.createTempFile("prev", "file").toUri();
  private static final String FILE_URL = "http://speedtest.ftp.otenet.gr/files/test10Mb.db";
  private static final int CONNECT_TIMEOUT = 10000;
  private static final int READ_TIMEOUT = 5000;
  private volatile boolean retriving = false;

  public LibraryLoaderProxy() throws IOException {
  }

  @Override
  public synchronized URI getBook() {
    if(!retriving) {
      Runnable task = () -> {
        try {
          var tempFile = Files.createTempFile("big", "file");
          FileUtils.copyURLToFile(
                  new URL(FILE_URL),
                  tempFile.toFile(),
                  CONNECT_TIMEOUT,
                  READ_TIMEOUT);
          this.pathToBook = tempFile.toUri();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      };
      new Thread(task).start();
      retriving = true;
    }

    if (this.pathToBook == null) {
      return prevPath;
    }

    return this.pathToBook;
  }
}
