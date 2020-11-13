package cl.inacap.covidEv.dao;

import java.util.List;
import cl.inacap.covidEv.dto.User;

public interface UserDAO {

    List<User> getAll();
    User save(User u);
}
