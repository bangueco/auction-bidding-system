package classes;

public class User {
  private String userName;
  private String password;

  public User(String username, String password) {
    this.userName = username;
    this.password = password;
  }

  public String getUsername() {
    return this.userName;
  }

  public String getPassword() {
    return this.password;
  }
}
