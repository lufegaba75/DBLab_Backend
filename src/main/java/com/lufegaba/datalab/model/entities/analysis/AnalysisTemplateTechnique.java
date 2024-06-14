package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.enumerations.Concentration;
import com.lufegaba.datalab.model.entities.enumerations.Quantity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisTemplateTechnique {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String aTTCode;

    @ManyToOne (cascade = CascadeType.DETACH)
    @JoinColumn (name = "analysisTemplate_id")
    private AnalysisTemplate analysisTemplate;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "templateTechnique_id")
    private TemplateTechnique technique;

    private Concentration concentration;

    private Quantity quantity;

    @JsonIgnore
    @OneToMany (mappedBy = "analysis")
    private List<AnalysisOrderDetails> orderDetailsList;

}
