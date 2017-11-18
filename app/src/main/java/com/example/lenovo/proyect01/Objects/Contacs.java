package com.example.lenovo.proyect01.Objects;

/**
 * Created by Lenovo on 26/06/2017.
 */

public class Contacs {
    public String name_contact;
    public String nickname_contact;
    public String birthday_contact;
    public String email_contact;
    public String reference_contact;

    public Contacs() {

    }

    public Contacs(String name_contact, String nickname_contact, String birthday_contact, String email_contact, String reference_contact) {
        this.name_contact = name_contact;
        this.nickname_contact = nickname_contact;
        this.birthday_contact = birthday_contact;
        this.email_contact = email_contact;
        this.reference_contact = reference_contact;
    }

    public String getName_contact() {
        return name_contact;
    }

    public void setName_contact(String name_contact) {
        this.name_contact = name_contact;
    }

    public String getNickname_contact() {
        return nickname_contact;
    }

    public void setNickname_contact(String nickname_contact) {
        this.nickname_contact = nickname_contact;
    }

    public String getBirthday_contact() {
        return birthday_contact;
    }

    public void setBirthday_contact(String birthday_contact) {
        this.birthday_contact = birthday_contact;
    }

    public String getEmail_contact() {
        return email_contact;
    }

    public void setEmail_contact(String email_contact) {
        this.email_contact = email_contact;
    }

    public String getReference_contact() {
        return reference_contact;
    }

    public void setReference_contact(String reference_contact) {
        this.reference_contact = reference_contact;
    }
}
