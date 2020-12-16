package com.company.dto;

import java.util.List;

public class UserDTO {

    private Integer id;

    private String name;

    private String surname;

    private List<String> addressList;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String surname, List<String> addressList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.addressList = addressList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }
}
