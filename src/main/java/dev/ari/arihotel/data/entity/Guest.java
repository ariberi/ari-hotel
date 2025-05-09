package dev.ari.arihotel.data.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "guests", schema = "LIL")
@Data
@ToString
public class Guest {

    @Id
    @Column(name = "guest_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "address")
    private String address;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "phone_number")
    private String phoneNumber;

}


