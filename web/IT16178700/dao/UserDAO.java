package IT16178700.dao;

import IT16178700.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUserDetails();
    boolean add(User user);
    boolean update(User user);
    boolean delete(User user);
    boolean get(User user);
}
