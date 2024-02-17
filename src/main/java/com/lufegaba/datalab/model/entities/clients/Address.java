package com.lufegaba.datalab.model.entities.clients;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.enumerations.WayType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private WayType wayType;
    private String firstLine;
    private String postalCode;
    private String town;
    private String province;

    @JsonIgnore
    @OneToOne (mappedBy = "address")
    private Client client;


}
