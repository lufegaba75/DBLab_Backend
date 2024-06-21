package com.lufegaba.datalab.model.entities.samples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.analysis.AnalysisOrder;
import com.lufegaba.datalab.model.entities.analysis.SampleTemplate;
import com.lufegaba.datalab.model.entities.analysis.Template;
import com.lufegaba.datalab.model.entities.enumerations.SampleState;
import com.lufegaba.datalab.model.entities.results.SampleResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sample {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name="sampling_id", referencedColumnName = "id")
    private Sampling sampling;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name="sampleType_id", referencedColumnName = "id")
    private SampleType sampleType;

    private String sampleDescription;
    private String additionalInfo;
    private String observations;

    private SampleState sampleState;

    @JsonIgnore
    @OneToMany (mappedBy = "sample")
    private List<SampleTemplate> sampleTemplates;
}
