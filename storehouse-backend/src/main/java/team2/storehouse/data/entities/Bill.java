package team2.storehouse.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BILL")
public class Bill {   // Fattura

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TAXES")
    private double taxes;

    @Basic(optional = false)
    @Column(name = "TOTAL")
    private double total;

    @Basic(optional = false)
    @Column(name = "DATE")
    private LocalDate date;

    @OneToOne(optional = false)
    @JoinColumn(name = "COMMAND", referencedColumnName = "ID")
    private Command command;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(bill.taxes, taxes) == 0 && Double.compare(bill.total, total) == 0 && Objects.equals(id, bill.id) && Objects.equals(date, bill.date) && Objects.equals(command, bill.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taxes, total, date, command);
    }
}
