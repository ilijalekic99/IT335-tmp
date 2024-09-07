package ac.rs.metropolitan.it355pzback.dao;

import ac.rs.metropolitan.it355pzback.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
