package proxy.virtual;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VirtualProxySolution {
  public static void main(String[] args) throws IOException, InterruptedException {
    var libraryLoader = new LibraryLoaderProxy();
    var path = libraryLoader.getBook();
    while (path.getPath().contains("prev")) {
      System.out.println("Prev path is: " + path);
      System.out.println("Continue loading...");
      TimeUnit.SECONDS.sleep(2);
      path = libraryLoader.getBook();
    }
    System.out.println("The loading has been finished.");
    System.out.println("Path is: " + path);
  }
}
