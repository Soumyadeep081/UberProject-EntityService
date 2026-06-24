package org.example.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExactLocation extends BaseModel{

    private Double latitude;
    private Double longitude;
}
