package org.example.uberprojectentityservice.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver extends BaseModel{
    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    private String phoneNumber;

    @OneToMany(mappedBy = "driver")
    @Fetch(FetchMode.SUBSELECT)
    List<Booking> bookings=new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    private boolean isAvailable;

    @DecimalMin(value = "0.00", message = "Rating must be greater than or equal to 0.00")
    @DecimalMax(value = "5.00", message = "Rating must be less than or equal to 5.00")
    private Double rating;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    private Car car;
}