package mx.com.realstate.administration.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the roles database table.
 *
 */
@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The role. */
    @Id
    private String name;

    /** The description. */
    private String description;

    /** The enabled. */
    private boolean enabled;

    /** The role module privileges. */
    @OneToMany(mappedBy = "role")
    private List<RoleModulePrivilege> roleModulePrivileges;

    /** The user roles. */
    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles;

    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the role.
     *
     * @param role
     *            the new role
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description
     *            the new description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets the enabled.
     *
     * @return the enabled
     */
    public boolean getEnabled() {
        return enabled;
    }

    /**
     * Sets the enabled.
     *
     * @param enabled
     *            the new enabled
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the role module privileges.
     *
     * @return the role module privileges
     */
    public List<RoleModulePrivilege> getRoleModulePrivileges() {
        return roleModulePrivileges;
    }

    /**
     * Sets the role module privileges.
     *
     * @param roleModulePrivileges
     *            the new role module privileges
     */
    public void setRoleModulePrivileges(final List<RoleModulePrivilege> roleModulePrivileges) {
        this.roleModulePrivileges = roleModulePrivileges;
    }

    /**
     * Adds the role module privilege.
     *
     * @param roleModulePrivilege
     *            the role module privilege
     * @return the role module privilege
     */
    public RoleModulePrivilege addRoleModulePrivilege(final RoleModulePrivilege roleModulePrivilege) {
        getRoleModulePrivileges().add(roleModulePrivilege);
        roleModulePrivilege.setRole(this);

        return roleModulePrivilege;
    }

    /**
     * Removes the role module privilege.
     *
     * @param roleModulePrivilege
     *            the role module privilege
     * @return the role module privilege
     */
    public RoleModulePrivilege removeRoleModulePrivilege(final RoleModulePrivilege roleModulePrivilege) {
        getRoleModulePrivileges().remove(roleModulePrivilege);
        roleModulePrivilege.setRole(null);

        return roleModulePrivilege;
    }

    /**
     * Gets the user roles.
     *
     * @return the user roles
     */
    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets the user roles.
     *
     * @param userRoles
     *            the new user roles
     */
    public void setUserRoles(final List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * Adds the user role.
     *
     * @param userRole
     *            the user role
     * @return the user role
     */
    public UserRole addUserRole(final UserRole userRole) {
        getUserRoles().add(userRole);
        userRole.setRole(this);

        return userRole;
    }

    /**
     * Removes the user role.
     *
     * @param userRole
     *            the user role
     * @return the user role
     */
    public UserRole removeUserRole(final UserRole userRole) {
        getUserRoles().remove(userRole);
        userRole.setRole(null);

        return userRole;
    }

}