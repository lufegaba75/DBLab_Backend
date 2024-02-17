package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.regulations.RegulationTemplate;
import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.model.entities.samples.SampleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String templateName;
    private boolean isActive;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private SampleType type;

    @JsonIgnore
    @OneToMany (mappedBy = "template",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<RegulationTemplate> regulationTemplateList;

}
