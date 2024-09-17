package com.estokay.api.entity;

import com.estokay.api.interfaces.Identifiable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "Donors")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Donor extends Person implements Identifiable, Serializable {

    @Column(name = "donations_made")
    private int donationsMade;

    public String toString() {
        return String.format("Name: %s, Phone: %s, Email: %s, Code: %s, Address: %s, City: %s, State: %s, IsActive: %b, Donations Made: %d"
                ,this.getName(), this.getPhone(), this.getEmail(), this.getCode(), this.getAddress(), this.getCity(), this.getState(),  this.isActive(), this.getDonationsMade());
    }

}
