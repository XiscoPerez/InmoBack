package mx.com.realstate.administration.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the role_module_privileges database table.
 *
 */
@Embeddable
public class RoleModulePrivilegePK implements Serializable {
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(insertable = false, updatable = false)
    private String role;

    @Column(insertable = false, updatable = false)
    private String privilege;

    @Column(insertable = false, updatable = false)
    private String module;

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(final String privilege) {
        this.privilege = privilege;
    }

    public String getModule() {
        return module;
    }

    public void setModule(final String module) {
        this.module = module;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleModulePrivilegePK)) {
            return false;
        }
        RoleModulePrivilegePK castOther = (RoleModulePrivilegePK) other;
        return role.equals(castOther.role) && privilege.equals(castOther.privilege) && module.equals(castOther.module);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + role.hashCode();
        hash = hash * prime + privilege.hashCode();
        hash = hash * prime + module.hashCode();

        return hash;
    }
}