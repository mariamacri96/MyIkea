package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Profile;
import team2.storehouse.data.entities.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ProfileDto implements Serializable {

    private String name;

    private String surname;

   // private Profile.Gender gender;

    private String fiscalCode;

    private String address;

    //private LocalDate birthdate;

    //private Long phone;

    private String photo;

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


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
