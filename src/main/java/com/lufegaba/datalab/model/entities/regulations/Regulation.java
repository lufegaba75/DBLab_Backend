package com.lufegaba.datalab.model.entities.regulations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.enumerations.RegulationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regulation {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String shortName;
    private String longName;

    private Boolean isActive;
    private RegulationType regulationType;

    @JsonIgnore
    @OneToMany (mappedBy = "regulation",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<RegulationTemplate> templateList;

}
