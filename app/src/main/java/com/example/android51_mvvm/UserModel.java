package com.example.android51_mvvm;

import androidx.databinding.ObservableField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserModel {
    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    public ObservableField<Boolean> isLogin = new ObservableField<>();
    public ObservableField<Integer> age = new ObservableField<>();
    public ObservableField<String> errorEmail = new ObservableField<>();
    public ObservableField<String> errorPassword = new ObservableField<>();
    public ObservableField<String> loginMessage = new ObservableField<>();
    public static final String URL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4CtaDk3U49ukzwQTk5h6n1mwtWT9HULw-piOF2eF4&s";

    public UserModel(String email, String password) {
        this.email.set(email);
        this.password.set(password);
    }

    @Override
    public String toString() {
        return "UserModel{" + "email='" + email.get() + '\'' + ", password='" + password.get() + '\'' + '}';
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    public void login() {
        if (!validateEmail(email.get())) {
            errorEmail.set("Please enter email format!");
            return;
        }
        if (password.get().length() <= 5) {
            errorPassword.set("Please enter > 5 characters");
            return;
        }
        errorEmail.set(null);
        errorPassword.set(null);

        if (email.get().equals("abc@gmail.com") && password.get().equals("123456")) {
            loginMessage.set("Login success!");
            isLogin.set(true);
        } else {
            isLogin.set(false);
            loginMessage.set("Login failed!");
        }
    }

    public void logout() {
        isLogin.set(false);
        loginMessage.set(null);
    }
}
