package proxy.remote;

import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SoftwareExecutorImpl extends UnicastRemoteObject implements SoftwareExecutor {
  private static final long serialVersionUID = 1L;

  public SoftwareExecutorImpl() throws RemoteException {
    Process process = null;
    try {
      var path = SoftwareExecutor.class.getProtectionDomain()
              .getCodeSource()
              .getLocation().getPath();
      process = Runtime.getRuntime().exec(
              new String[]{"rmiregistry"},
              new String[]{},
              new File(path));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(process);
  }

  @Override
  public boolean execute(String path) {
    try {
      var process = Runtime.getRuntime().exec(new String[]{path});
      System.out.println(process);
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  public static void main(String[] args) throws IOException {
    SoftwareExecutor executor = new SoftwareExecutorImpl();
    Naming.rebind("//localhost/executor", executor);
  }
}
