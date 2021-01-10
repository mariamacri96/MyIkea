package team2.storehouse.data.entities;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.Set;

@Entity
@Table(name="INVOICE")
public class Invoice {
    public enum Method {
        VISA, POSTEPAY, MASTERCARD,AMERICAN_EXPRESS, PAYPAL,RATE,FINANCING,CASH
    }
    public enum Status {
        COMPLETED, INCOMPLETED, FAILED, INITIAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "ORDER_ID")
    private Long order_id;


    //user
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;


    @Column(name = "USER_VAT_NUMBER", length=11)
    private String userVATNumber;

    @Basic
    @Column(name="USER_ADDRESS")
    private String userAddress;

  /*  @Basic
    @Column(name="USER_CAP")
    private int userCap;

    @Basic
    @Column(name="USER_CITY")
    private String userCity;

    @Basic
    @Column(name="USER_PROVINCE")
    private String userProvince;

*/
    //product
    @OneToMany
    @JoinColumn(name = "invoice_id")
    private Set<Product> productList;


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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserVATNumber() {
        return userVATNumber;
    }

    public void setUserVATNumber(String userVATNumber) {
        this.userVATNumber = userVATNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
/*
    public int getUserCap() {
        return userCap;
    }

    public void setUserCap(int userCap) {
        this.userCap = userCap;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }
*/
    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
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

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
}
