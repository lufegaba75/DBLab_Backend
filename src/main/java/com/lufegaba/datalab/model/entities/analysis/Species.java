package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.analysis.Parameter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Species {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String speciesName;

    @JsonIgnore
    @OneToMany (mappedBy = "species",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Parameter> parameterList;

}
