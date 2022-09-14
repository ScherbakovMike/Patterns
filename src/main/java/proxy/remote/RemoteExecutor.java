package proxy.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteExecutor extends UnicastRemoteObject implements SoftwareExecutor {
  private static final long serialVersionUID = 1L;
  private String rmiPath = "rmi://localhost/executor";
  protected RemoteExecutor() throws RemoteException {
  }

  @Override
  public boolean execute(String path) throws RemoteException {
    SoftwareExecutor executor = null;
    try {
      executor = (SoftwareExecutor) Naming.lookup(rmiPath);
    } catch (NotBoundException | MalformedURLException e ) {
      throw new RuntimeException(e);
    }
    return executor.execute(path);
  }

  public static void main(String[] args) throws RemoteException {
    System.out.println(new RemoteExecutor().execute("cmd.exe"));
  }
}
