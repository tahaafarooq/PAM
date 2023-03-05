package com.tahaafarooq.pam;

public class PasswordModal {
    private String username;
    private String password;
    private String host;
    private int id;

    public String getHost() { return host; }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PasswordModal(String username, String password, String host) {
        this.username = username;
        this.password = password;
        this.host = host;
    }
}
