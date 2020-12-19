package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Command;

import java.io.Serializable;
import java.time.LocalDate;

public class BillDto implements Serializable {
    private Long id;

    private double taxes;

    private double total;

    private LocalDate date;

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
}
