package com.mta.dogwalkerserver.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;



@Entity(name = "dog_walker")
@Table(name = "dog_walker", schema = "dog_walker_app")
@Access(value=AccessType.FIELD)
public class DogWalker extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "HOUR_SALARY")
    private int hourSalary;

    //  https://www.baeldung.com/jackson-ignore-properties-on-serialization
    @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true )
    @JoinColumn(name = "CONTACT_DogOwner")
    @JsonIgnore
    private Set<DogOwner> contact = new HashSet<DogOwner>();

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "address_Id")
    private Address address_Id;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "image_Id")
    private Image image_Id;

//
//    @Column(name="GeoHashLocation")
//    @Formula("address_Id.getGeoHashLocation()")
//    private String geoHashLocation;


    //CONSTRUCTOR
    public DogWalker() {
    }
    //    public DogWalker(String firstName, String lastName, String userName, String email, String aboutMyself, Date birthDay, String phone, Gender gender, int hourSalary, Set<DogOwner> contact, Address address_Id, Image image_Id, String geoHashLocation) {
//        super(firstName, lastName, userName, email, aboutMyself, birthDay, phone, gender);
//        this.hourSalary = hourSalary;
//        this.contact = contact;
//        this.address_Id = address_Id;
//        this.image_Id = image_Id;
//        this.geoHashLocation = geoHashLocation;
//    }
    public DogWalker(String firstName, String lastName, String userName, String email, String aboutMyself, Date birthDay, String phone, Gender gender, int hourSalary, Set<DogOwner> contact, Address address_Id, Image image_Id) {
        super(firstName, lastName, userName, email, aboutMyself, birthDay, phone, gender);
        this.hourSalary = hourSalary;
        this.contact = contact;
        this.address_Id = address_Id;
        this.image_Id = image_Id;
    }

    //getter and setter
    public int getHourSalary() {
        return hourSalary;
    }
    public void setHourSalary(int hourSalary) {
        this.hourSalary = hourSalary;
    }
    public Set<DogOwner> getContact() {
        return contact;
    }
    public void setContact(Set<DogOwner> contact) {
        this.contact = contact;
    }
    public Address getAddress_Id() {
        return address_Id;
    }
    public void setAddress_Id(Address address_Id) {
        this.address_Id = address_Id;
    }
    public Image getImage_Id() {
        return image_Id;
    }
    public void setImage_Id(Image image_Id) {
        this.image_Id = image_Id;
    }
//    public String getGeoHashLocation() {
//        return geoHashLocation;
//    }
//    public void setGeoHashLocation(String geoHashLocation) {
//        this.geoHashLocation = geoHashLocation;
//    }
}
