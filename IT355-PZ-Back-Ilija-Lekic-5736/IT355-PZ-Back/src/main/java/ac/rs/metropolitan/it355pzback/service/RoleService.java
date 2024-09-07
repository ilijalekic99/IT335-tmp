package ac.rs.metropolitan.it355pzback.service;

import ac.rs.metropolitan.it355pzback.dao.RoleDao;
import ac.rs.metropolitan.it355pzback.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole (Role role) {
        return roleDao.save(role);
    }
}

