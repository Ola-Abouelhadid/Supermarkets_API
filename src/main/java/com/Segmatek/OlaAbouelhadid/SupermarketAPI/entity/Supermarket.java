package com.Segmatek.OlaAbouelhadid.SupermarketAPI.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

// Annotation to tell Hibernate that this is a class that maps to a database table
@Entity
@Table(name="supermarket")
public class Supermarket {
//    define fields
//    match the fields to the database table columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;



    @Column(name="arabic_name")
    private String arabicName;

    @Column(name="english_name")
    private String englishName;
    @Column(name="address")
    private String address;

    @Column(name="image")
    private String image;

    @Column(name="active")
    private boolean active;

//    define constructors
    public Supermarket() {

    }

    public Supermarket(String arabicName, String englishName, String address, String image, boolean active) {
        this.arabicName = arabicName;
        this.englishName = englishName;
        this.address = address;
        this.image = image;
        this.active = active;
    }

//    define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    //    define toString


    @Override
    public String toString() {
        return "Supermarket{" +
                "id=" + id +
                ", arabicName='" + arabicName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", active=" + active +
                '}';
    }
}
