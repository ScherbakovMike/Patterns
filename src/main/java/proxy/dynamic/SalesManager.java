package proxy.dynamic;

public class SalesManager implements User {
  @Override
  public boolean canChangePassword() {
    return false;
  }
}
