package mx.com.realstate.administration.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import mx.com.realstate.administration.utils.RealStateUtils;

public class UserDto {
    @NotNull
    @Size(min = 6, max = 25)
    private String username;

    @NotNull
    @Size(min = 8, max = 25)
    private String password;

    @NotNull
    @Size(min = 8, max = 45)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return RealStateUtils.requestJson(this);
    }

}
