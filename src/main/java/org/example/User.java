package org.example;

import java.util.Objects;

public class User {
    private String userLogin;


    private String userEmail;

    public User(String userLogin, String userEmail) {
        if (userLogin.isEmpty() || userLogin.isBlank() || userLogin == null) {
            throw new RuntimeException("Некорректно введен логин");
        }
        if (userEmail.isEmpty() || userEmail.isBlank() || userEmail == null) {
            throw new RuntimeException("Вы не ввели email");
        }
        if (!userEmail.contains("@")) {
            throw new RuntimeException("в email не хватает знака @");
        }
        if (!userEmail.contains(".")) {
            throw new RuntimeException("в email не хватает знака .");
        }
        if (userEmail.equals(userLogin)) {
            throw new RuntimeException("Логин и emeil не могут быть одинаковы");
        }
        this.userLogin = userLogin;
        this.userEmail = userEmail;
    }

    public User() {
        this.userLogin = null;
        if (userLogin == null) {
            throw new RuntimeException("Не введен логин");
        }

        this.userEmail = null;
        if (userEmail == null) {
            throw new RuntimeException("Вы не ввели email");
        }
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return userLogin.equals(user.userLogin) && userEmail.equals(user.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, userEmail);
    }
}
