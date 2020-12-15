package team2.storehouse.data.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {

    private String username;

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return email.equals(userDto.email) &&
                Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
