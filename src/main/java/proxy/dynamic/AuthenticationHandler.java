package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AuthenticationHandler implements InvocationHandler {
  private final PasswordStorage storage;

  public AuthenticationHandler(PasswordStorage storage) {
    this.storage = storage;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    if (method.getName().equals("changePassword")) {
      var user = (User) args[1];
      if (user instanceof Admin) {
        storage.changePassword((String) args[0], user);
      } else {
        System.out.println("Only Admin can change password!");
      }
    }
    return null;
  }
}
