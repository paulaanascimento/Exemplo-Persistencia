package dao;

import model.User;

public interface UserDAO {
    User getUserByEmail(String email);

    boolean emailExists(String email);

    void createUser(User newUser);
}
