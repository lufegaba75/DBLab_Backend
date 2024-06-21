package com.lufegaba.datalab.model.entities.results;

import com.lufegaba.datalab.model.entities.analysis.AnalysisOrderDetails;
import com.lufegaba.datalab.model.entities.analysis.TemplateTechnique;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "orderDetails_id", referencedColumnName = "id")
    private AnalysisOrderDetails analysisOrderDetails;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "sampleResult_id", referencedColumnName = "id")
    private SampleResult sampleResult;

    private Double numericResult;
    private String textResult;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "template_technique_id", referencedColumnName = "id")
    private TemplateTechnique technique;

}
