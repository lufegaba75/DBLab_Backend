package com.lufegaba.datalab.model.entities.regulations;

import com.lufegaba.datalab.model.entities.analysis.TemplateTechnique;
import com.lufegaba.datalab.model.entities.enumerations.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegulationCriteria {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String criteriaName;
    private Double minValue;
    private Double maxValue;

    private Unit unit;

    @ManyToOne (cascade = CascadeType.DETACH)
    @JoinColumn (name = "regulationTemplate", referencedColumnName = "id")
    private RegulationTemplate template;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "technique_id", referencedColumnName = "id")
    private TemplateTechnique technique;

    private boolean isOk;

}
