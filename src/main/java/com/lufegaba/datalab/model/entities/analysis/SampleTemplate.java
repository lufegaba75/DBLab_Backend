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
public class SampleTemplate {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime assignedAt;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "sample_id", referencedColumnName = "id")
    private Sample sample;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "template_id", referencedColumnName = "id")
    private Template template;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "worker_id", referencedColumnName = "id")
    private Worker assignedBy;

    @JsonIgnore
    @OneToMany (mappedBy = "sampleTemplate")
    private List<AnalysisOrder> orders;
}
