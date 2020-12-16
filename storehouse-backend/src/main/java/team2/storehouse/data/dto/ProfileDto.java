package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Profile;
import team2.storehouse.data.entities.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ProfileDto implements Serializable {    // really needed?

    public enum Gender {
        MALE, FEMALE
    }

    private Long id;

    private String name;

    private String surname;

    private Profile.Gender gender;

    private String fiscalCode;

    private String address;

    private LocalDate birthdate;

    private Long phone;

    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

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

    public Profile.Gender getGender() {
        return gender;
    }

    public void setGender(Profile.Gender gender) {
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

}
