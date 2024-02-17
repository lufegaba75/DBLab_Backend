package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.results.ResultDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateTechnique {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String code;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "template_id", referencedColumnName = "id")
    private Template template;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "technique_id", referencedColumnName = "id")
    private Technique technique;

    @JsonIgnore
    @OneToMany (mappedBy = "technique",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<AnalysisTemplateTechnique> analysisTechniquesList;

    @JsonIgnore
    @OneToMany (mappedBy = "technique",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<ResultDetails> resultDetailsList;
}
