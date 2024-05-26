package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.regulations.RegulationCriteria;
import com.lufegaba.datalab.model.entities.enumerations.ParameterType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String parameterCode;
    private String parameterName;

    @JsonIgnore
    @OneToMany (mappedBy = "parameter",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Technique> techniqueList;

    private ParameterType parameterType;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "species_id", referencedColumnName = "id")
    private Species species;


}
