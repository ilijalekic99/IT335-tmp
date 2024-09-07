package ac.rs.metropolitan.it355pzback.dao;

import ac.rs.metropolitan.it355pzback.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
