package org.example.uberprojectentityservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger extends BaseModel{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "passenger")
    List<Booking> bookings=new ArrayList<>();

    @OneToOne
    private Booking activeBooking;

    @DecimalMin(value = "0.00", message = "Rating must be greater than or equal to 0.00")
    @DecimalMax(value = "5.00", message = "Rating must be less than or equal to 5.00")
    private Double rating;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;
}
