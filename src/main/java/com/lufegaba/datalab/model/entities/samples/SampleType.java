package com.lufegaba.datalab.model.entities.samples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.enumerations.SampleGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleType {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private SampleGroup sampleGroup;

    private String sampleType;

    @JsonIgnore
    @OneToMany (mappedBy = "sampleType")
    private List<Sample> sampleList;

    @JsonIgnore
    @OneToMany (mappedBy = "type")
    private List<Template> templateList;
}
