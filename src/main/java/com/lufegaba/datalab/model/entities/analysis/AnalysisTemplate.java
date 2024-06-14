package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisTemplate {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "template_id")
    private Template template;

    private String description;

    private boolean isActive;

    @JsonIgnore
    @OneToMany (mappedBy = "analysisTemplate")
    private List<AnalysisOrder> analysisOrderList;

    @JsonIgnore
    @OneToMany (mappedBy = "analysisTemplate")
    private List<AnalysisTemplateTechnique> analysisTemplateTechniqueList;

}
