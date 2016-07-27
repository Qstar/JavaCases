package Network.TCP.Socket;

import java.io.Serializable;

class User implements Serializable {
    public String name;
    public String Password;

    User(String name, String password) {
        this.name = name;
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
