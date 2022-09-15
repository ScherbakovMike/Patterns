package proxy.dynamic;

public class Admin implements User {
  @Override
  public boolean canChangePassword() {
    return true;
  }
}
