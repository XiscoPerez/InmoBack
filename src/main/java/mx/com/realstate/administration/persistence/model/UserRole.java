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
 * The persistent class for the user_roles database table.
 *
 */
@Entity
@Table(name = "user_roles")
@NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserRolePK id;

    private boolean enabled;

    // bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name = "role", insertable = false, updatable = false)
    private Role role;

    // bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;

    @PrePersist
    private void prePersiste() {
        if (id == null) {
            id = new UserRolePK();
            id.setRole(role.getName());
            id.setUsername(user.getUsername());
        }
    }

    public UserRolePK getId() {
        return id;
    }

    public void setId(final UserRolePK id) {
        this.id = id;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

}