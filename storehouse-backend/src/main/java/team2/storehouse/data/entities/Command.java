package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COMMAND")
public class Command {    // I don't know why if I try to rename it Order it will throws some exceptions

    public enum State {
        NOT_TRANSMITTED, // when the client or the employee creates the command
        TRANSMITTED,     // when the client sends the command to the employee
        IN_PROCESSING,   // when the employee see it and starts processing it
        CONFIRMED,       // when the client or the employee confirm the command
        CLOSED           // when the client pays (bill emission)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Enumerated
    @Column(name = "STATE")
    private State state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER", referencedColumnName = "ID")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return Objects.equals(id, command.id) && state == command.state && Objects.equals(user, command.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, user);
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", state=" + state +
                ", user=" + user +
                '}';
    }
}
