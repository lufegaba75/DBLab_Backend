package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.analysis.Parameter;
import com.lufegaba.datalab.model.entities.regulations.RegulationCriteria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technique {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String techniqueName;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "parameter_id", referencedColumnName = "id")
    private Parameter parameter;

    @JsonIgnore
    @OneToMany (mappedBy = "technique",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<TemplateTechnique> templateTechniqueList;

    @JsonIgnore
    @OneToMany (mappedBy = "technique",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<RegulationCriteria> regulationCriteriaList;
}
