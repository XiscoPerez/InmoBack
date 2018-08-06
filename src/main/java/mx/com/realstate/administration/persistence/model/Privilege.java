package mx.com.realstate.administration.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the privileges database table.
 *
 */
@Entity
@Table(name = "privileges")
@NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p")
public class Privilege implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    private String description;

    private boolean enabled;

    // bi-directional many-to-one association to RoleModulePrivilege
    @OneToMany(mappedBy = "privilege")
    private List<RoleModulePrivilege> roleModulePrivileges;

    public String getPrivilege() {
        return name;
    }

    public void setPrivilege(final String privilege) {
        name = privilege;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public List<RoleModulePrivilege> getRoleModulePrivileges() {
        return roleModulePrivileges;
    }

    public void setRoleModulePrivileges(final List<RoleModulePrivilege> roleModulePrivileges) {
        this.roleModulePrivileges = roleModulePrivileges;
    }

    public RoleModulePrivilege addRoleModulePrivilege(final RoleModulePrivilege roleModulePrivilege) {
        getRoleModulePrivileges().add(roleModulePrivilege);
        roleModulePrivilege.setPrivilege(this);

        return roleModulePrivilege;
    }

    public RoleModulePrivilege removeRoleModulePrivilege(final RoleModulePrivilege roleModulePrivilege) {
        getRoleModulePrivileges().remove(roleModulePrivilege);
        roleModulePrivilege.setPrivilege(null);

        return roleModulePrivilege;
    }

}