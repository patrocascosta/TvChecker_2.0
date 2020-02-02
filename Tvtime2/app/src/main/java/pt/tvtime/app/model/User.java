package pt.tvtime.app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey()
    private long userId;
    private String password;
    private String email;

    public User() {
    }

    public long getUserId() {

        return userId;
    }
    public void setId(long id) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email= email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
