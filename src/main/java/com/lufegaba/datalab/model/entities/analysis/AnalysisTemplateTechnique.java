package com.lufegaba.datalab.model.entities.analysis;

import com.lufegaba.datalab.model.entities.enumerations.Concentration;
import com.lufegaba.datalab.model.entities.enumerations.Quantity;

import jakarta.persistence.*;
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

    private String ATTCode;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "analysisTemplate_id", referencedColumnName = "id", nullable = false)
    private AnalysisTemplate analysisTemplate;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "templateTechnique_id")
    private TemplateTechnique technique;

    private Concentration concentration;

    private Quantity quantity;

    @OneToMany (mappedBy = "analysis",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<AnalysisOrderDetails> orderDetailsList;

}
