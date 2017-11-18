package com.example.lenovo.proyect01.Objects;

/**
 * Created by Lenovo on 28/06/2017.
 */

public class Video {
    public String video;
    public String reference_contact;

    public Video() {
    }

    public Video(String video, String reference_contact) {
        this.video = video;
        this.reference_contact = reference_contact;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getReference_contact() {
        return reference_contact;
    }

    public void setReference_contact(String reference_contact) {
        this.reference_contact = reference_contact;
    }
}
