package model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "nickname")
    private String nickname;

    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public String getNickname(){
        return nickname;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
