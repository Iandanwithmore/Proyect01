package com.example.lenovo.proyect01.Objects;

/**
 * Created by Lenovo on 28/06/2017.
 */

public class Image {
    public String name;
    public String reference_contact;

    public Image() {
    }

    public Image(String name, String reference_contact) {
        this.name = name;
        this.reference_contact = reference_contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String text) {
        this.name = text;
    }

    public String getReference_contact() {
        return reference_contact;
    }

    public void setReference_contact(String reference_contact) {
        this.reference_contact = reference_contact;
    }
}
