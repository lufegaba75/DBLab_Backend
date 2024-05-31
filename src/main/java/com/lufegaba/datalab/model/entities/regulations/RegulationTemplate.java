package com.lufegaba.datalab.model.entities.regulations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.regulations.Regulation;
import com.lufegaba.datalab.model.entities.regulations.RegulationCriteria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RegulationTemplate {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String regulationTemplate;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "regulation_id")
    private Regulation regulation;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "template_id")
    private Template template;

    private Boolean everythingIsOk;

    @JsonIgnore
    @OneToMany (mappedBy = "template",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<RegulationCriteria> criteriaList;
}
