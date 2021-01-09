package team2.storehouse.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BILL")
public class Bill {   // Fattura
    public enum Method {
        VISA, POSTEPAY, MASTERCARD,AMERICAN_EXPRESS, PAYPAL,RATE,FINANCING
    }
    public enum Status {
        COMPLETED, INCOMPLETED, FAILED, INITIAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Number of bill

    @Column(name = "TAXES")
    private double taxes;

    @Column(name = "TOTAL_TAXABLE")
    private double totalTaxable;

    @Column(name = "NET_TO_PAY")
    private double netToPay;

    @Basic(optional = false)
    @Column(name = "TOTAL")
    private double total;

    @Basic(optional = false)
    @Column(name = "DATE")
    private LocalDate date;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name="METHOD_PAYMENT")
    private Method methodPayment;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name="STATUS_PAYMENT")
    private Status statusPayment;

    @Basic(optional = false)
    @Column(name="IBAN")
    private String iban;

    @Basic
    @Column(name="BANK")
    private String bankName;

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

    public double getTotalTaxable() {
        return totalTaxable;
    }

    public void setTotalTaxable(double totalTaxable) {
        this.totalTaxable = totalTaxable;
    }

    public double getNetToPay() {
        return netToPay;
    }

    public void setNetToPay(double netToPay) {
        this.netToPay = netToPay;
    }

    public Method getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(Method methodPayment) {
        this.methodPayment = methodPayment;
    }

    public Status getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(Status statusPayment) {
        this.statusPayment = statusPayment;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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
