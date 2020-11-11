package cl.sema.covidev.dao;

import java.util.List;
import cl.sema.covidev.dto.User;

public interface UserDAO {

    List<User> getAll();
    User save(User u);
}
