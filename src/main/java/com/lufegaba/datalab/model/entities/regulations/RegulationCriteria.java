package com.lufegaba.datalab.model.entities.regulations;

import com.lufegaba.datalab.model.entities.analysis.Parameter;
import com.lufegaba.datalab.model.entities.analysis.Technique;
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

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "regulationTemplate", referencedColumnName = "id")
    private RegulationTemplate template;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "technique_id", referencedColumnName = "id")
    private Technique technique;

    private boolean isOk;

}
