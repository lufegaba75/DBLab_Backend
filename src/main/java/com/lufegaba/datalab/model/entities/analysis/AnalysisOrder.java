package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.results.SampleResult;
import com.lufegaba.datalab.model.entities.samples.Sample;
import com.lufegaba.datalab.model.entities.users.Worker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisOrder {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime orderDate;
    private LocalDateTime startDate;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "sample_id", referencedColumnName = "id")
    private SampleTemplate sampleTemplate;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "analysisTemplate_id", referencedColumnName = "id")
    private AnalysisTemplate analysisTemplate;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "worker_id", referencedColumnName = "id")
    private Worker orderedBy;

    @JsonIgnore
    @OneToMany (mappedBy = "analysisOrder")
    private List<AnalysisOrderDetails> orderDetailsList;

    @JsonIgnore
    @OneToMany (mappedBy = "order")
    private List<SampleResult> results;

}
