package mx.com.realstate.administration.persistence.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * The persistent class for the role_module_privileges database table.
 *
 */
@Entity
@Table(name = "role_module_privileges")
@NamedQuery(name = "RoleModulePrivilege.findAll", query = "SELECT r FROM RoleModulePrivilege r")
public class RoleModulePrivilege implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RoleModulePrivilegePK id;

    private boolean enabled;

    // bi-directional many-to-one association to Module
    @ManyToOne
    @JoinColumn(name = "module", insertable = false, updatable = false)
    private Module module;

    // bi-directional many-to-one association to Privilege
    @ManyToOne
    @JoinColumn(name = "privilege", insertable = false, updatable = false)
    private Privilege privilege;

    // bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name = "role", insertable = false, updatable = false)
    private Role role;

    @PrePersist
    private void prePersiste() {
        if (id == null) {
            id = new RoleModulePrivilegePK();
            id.setRole(role.getName());
            id.setModule(module.getName());
            id.setPrivilege(privilege.getPrivilege());
        }
    }

    public RoleModulePrivilegePK getId() {
        return id;
    }

    public void setId(final RoleModulePrivilegePK id) {
        this.id = id;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(final Module module) {
        this.module = module;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(final Privilege privilege) {
        this.privilege = privilege;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

}