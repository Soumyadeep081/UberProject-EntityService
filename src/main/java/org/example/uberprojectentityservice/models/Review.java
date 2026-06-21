package org.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking_Review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @OneToOne(cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY)  //1:1 relation between booking and review
    @JoinColumn(nullable = false)
    private Booking booking; //booking has-a review (composition)


    @Column(nullable = false)
    private String content;

    private Double rating;

    @Override
    public String toString(){
        return "Review: " + this.content + " " + this.rating + " booking" + this.booking.getId() + " " + this.createdAt;
    }
}
