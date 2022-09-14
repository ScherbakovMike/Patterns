package proxy.virtual;

import java.io.IOException;
import java.net.URI;

public interface LibraryLoader {
  URI getBook() throws IOException;
}
