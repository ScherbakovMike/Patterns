package proxy.dynamic;

import java.lang.reflect.Proxy;

public class DynamicProxySolution {
  public static void main(String[] args) {
    var authenticationGate = (PasswordStorage) Proxy.newProxyInstance(PasswordStorageImpl.class.getClassLoader(),
            new Class[]{PasswordStorage.class},
            new AuthenticationHandler(new PasswordStorageImpl()));
    var salesManager = new SalesManager();
    var admin = new Admin();

    authenticationGate.changePassword("newPassword", salesManager);
    authenticationGate.changePassword("newPassword", admin);
  }
}
