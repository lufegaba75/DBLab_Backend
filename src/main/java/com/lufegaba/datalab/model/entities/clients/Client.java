package com.lufegaba.datalab.model.entities.clients;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.samples.Sampling;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String clientName;

    @Email
    private String email;

    @OneToOne
    @JoinColumn (name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne
    @JoinColumn (name = "phone_id", referencedColumnName = "id")
    private Phone phone;

    @JsonIgnore
    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL)
    private List<Sampling> samplingList;

}
