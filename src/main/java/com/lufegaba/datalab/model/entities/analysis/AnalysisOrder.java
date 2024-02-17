package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.samples.Sample;
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

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sample_id", referencedColumnName = "id")
    private Sample sample;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "analysisTemplate_id", referencedColumnName = "id")
    private AnalysisTemplate analysisTemplate;

    @JsonIgnore
    @OneToMany (mappedBy = "order",
                orphanRemoval = true,
                cascade = CascadeType.ALL)
    private List<AnalysisOrderDetails> orderDetailsList;

}
