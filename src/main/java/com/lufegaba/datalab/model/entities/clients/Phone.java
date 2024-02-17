package com.lufegaba.datalab.model.entities.clients;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.clients.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Length(min=2, max=3)
    private String internationalCode;
    private String phoneNumber;
    private Boolean activeNumber;

    @JsonIgnore
    @OneToOne(mappedBy = "phone")
    private Client client;

}
