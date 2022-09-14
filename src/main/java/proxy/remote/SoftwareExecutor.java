package proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SoftwareExecutor extends Remote {
  boolean execute(String path) throws RemoteException;
}
