package proxy.dynamic;

public interface PasswordStorage {
  void changePassword(String newPassword, User user);
}
