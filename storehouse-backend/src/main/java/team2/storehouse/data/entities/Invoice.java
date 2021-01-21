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


    //Invoice parameters
    @Basic
    @Column(name = "TYPE_DOCUMENT")
    private String  typeDocument;

    @Basic
    @Column(name = "DOCUMENT_NUMBER")
    private Long documentNumber;

    @Basic
    @Column(name = "DOCUMENT_DATE")
    private LocalDate documentDate;

    @Basic
    @Column(name = "TRANSMISSION_ADDRESS")
    private String transmissionAddress;

    @Basic
    @Column(name = "CAUSAL")
    private String causal;

    //user
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;


    @Column(name = "USER_CF")
    private String userCF;

    @Basic
    @Column(name="USER_ADDRESS")
    private String userAddress;

   @Basic
    @Column(name="USER_CAP")
    private int userCap;

    @Basic
    @Column(name="USER_CITY")
    private String userCity;


    @Basic
    @Column(name="USER_PROVINCE")
    private String userProvince;




    //summary
    @Column(name = "VAT_COLLECTABILITY")
    private String vatCollectability;

    @Column(name = "ADDITIONAL_COSTS")
    private String additionalCosts; //spese accessorie

    @Column(name = "TOTAL_TAXABLE")
    private double totalTaxable;

    @Column(name = "TOTAL_TAXES")
    private double totalTaxes;

    @Column(name = "STAMP_DATA")
    private String stampData;//bollo

    @Column(name = "DISCOUNT")
    private double discount;

    @Column(name = "TOTAL_DOCUMENT")
    private double totalDocument;

    //payment

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

    @Column(name="EXPIRATION_DATE")
    private LocalDate expirationDate;

    @Column(name = "NET_TO_PAY")
    private double netToPay;


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

    public String getUserCF() {
        return userCF;
    }

    public void setUserCF(String userCF) {
        this.userCF = userCF;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

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

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public String getTransmissionAddress() {
        return transmissionAddress;
    }

    public void setTransmissionAddress(String transmissionAddress) {
        this.transmissionAddress = transmissionAddress;
    }

    public String getCausal() {
        return causal;
    }

    public void setCausal(String causal) {
        this.causal = causal;
    }

    public String getVatCollectability() {
        return vatCollectability;
    }

    public void setVatCollectability(String vatCollectability) {
        this.vatCollectability = vatCollectability;
    }

    public String getAdditionalCosts() {
        return additionalCosts;
    }

    public void setAdditionalCosts(String additionalCosts) {
        this.additionalCosts = additionalCosts;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public String getStampData() {
        return stampData;
    }

    public void setStampData(String stampData) {
        this.stampData = stampData;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalDocument() {
        return totalDocument;
    }

    public void setTotalDocument(double totalDocument) {
        this.totalDocument = totalDocument;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
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
