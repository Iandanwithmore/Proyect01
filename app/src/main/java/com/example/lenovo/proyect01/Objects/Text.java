package com.example.lenovo.proyect01.Objects;

/**
 * Created by Lenovo on 28/06/2017.
 */

public class Text {
    public String text;
    public String reference_contact;

    public Text() {
    }

    public Text(String text, String reference_contact) {
        this.text = text;
        this.reference_contact = reference_contact;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReference_contact() {
        return reference_contact;
    }

    public void setReference_contact(String reference_contact) {
        this.reference_contact = reference_contact;
    }
}
