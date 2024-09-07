package ac.rs.metropolitan.it355pzback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private String roleName;
    private String roleDescription;

    // Podrazumevani konstruktor
    public Role() {
    }

    // Konstruktor sa oba parametra
    public Role(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    // Novi konstruktor koji prihvata samo roleName
    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
