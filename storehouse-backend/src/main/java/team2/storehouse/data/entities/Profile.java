package team2.storehouse.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PROFILE")
public class Profile {

    public enum Gender {
        MALE, FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    @Basic(optional = false)
    @Column(name = "SURNAME")
    private String surname;

    @Basic(optional = false)
    @Enumerated
    @Column(name = "GENDER")
    private Gender gender;

    @Basic(optional = false)
    @Column(name = "FISCAL_CODE")
    private String fiscalCode;

    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;

    @Basic(optional = false)
    @Column(name = "BIRTHDATE")
    private LocalDate birthdate;

    @Basic(optional = false)
    @Column(name = "PHONE")
    private Long phone;

    @Column(name = "PHOTO")
    private String photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) && Objects.equals(name, profile.name) && Objects.equals(surname, profile.surname) && gender == profile.gender && Objects.equals(fiscalCode, profile.fiscalCode) && Objects.equals(address, profile.address) && Objects.equals(birthdate, profile.birthdate) && Objects.equals(phone, profile.phone) && Objects.equals(photo, profile.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, gender, fiscalCode, address, birthdate, phone, photo);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", fiscalCode='" + fiscalCode + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                ", phone=" + phone +
                ", photo='" + photo + '\'' +
                '}';
    }
}
