package me.ramonper.asyncexample.obj;

import java.util.concurrent.Callable;

public class ObjectEmail implements Callable<String> {

    private String userName;
    private String email;
    private String emailPassword;
    private String recipient;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String call() {
        return getRecipient();
    }
}
