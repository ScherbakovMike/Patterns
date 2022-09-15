package proxy.dynamic;

public class PasswordStorageImpl implements PasswordStorage {

  private String password;

  @Override
  public void changePassword(String newPassword, User user) {
    this.password = newPassword;
    System.out.println("Password has been changed!");
  }
}
