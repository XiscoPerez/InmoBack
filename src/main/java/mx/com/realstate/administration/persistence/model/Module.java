package mx.com.realstate.administration.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the modules database table.
 *
 */
@Entity
@Table(name = "modules")
@NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m")
public class Module implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    private String description;

    private boolean enabled;

    // bi-directional many-to-one association to RoleModulePrivilege
    @OneToMany(mappedBy = "module")
    private List<RoleModulePrivilege> roleModulePrivileges;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
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
        roleModulePrivilege.setModule(this);

        return roleModulePrivilege;
    }

    public RoleModulePrivilege removeRoleModulePrivilege(final RoleModulePrivilege roleModulePrivilege) {
        getRoleModulePrivileges().remove(roleModulePrivilege);
        roleModulePrivilege.setModule(null);

        return roleModulePrivilege;
    }

}