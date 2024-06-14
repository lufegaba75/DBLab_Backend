package com.lufegaba.datalab.model.entities.analysis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.results.ResultDetails;
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
public class AnalysisOrderDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "analysis_id", referencedColumnName = "id")
    private AnalysisTemplateTechnique analysis;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "order_id", referencedColumnName = "id")
    private AnalysisOrder order;

    @JsonIgnore
    @OneToMany (mappedBy = "analysisOrderDetail")
    private List<Measurement> measurements;

    @JsonIgnore
    @OneToMany (mappedBy = "analysisOrderDetails")
    private List<ResultDetails> resultDetailsList;
}
