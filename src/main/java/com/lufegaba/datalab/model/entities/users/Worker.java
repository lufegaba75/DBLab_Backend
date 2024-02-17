package com.lufegaba.datalab.model.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.analysis.AnalysisOrderDetails;
import com.lufegaba.datalab.model.entities.enumerations.WorkerType;
import com.lufegaba.datalab.model.entities.results.SampleResult;
import com.lufegaba.datalab.model.entities.samples.Sampling;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private WorkerType workerType;
    private String firstName;
    private String lastName;

    @Email
    private String email;

    @JsonIgnore
    @OneToMany (mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Sampling> samplingList;

    @JsonIgnore
    @OneToMany (mappedBy = "analyst",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<AnalysisOrderDetails> analysisDetailsList;

    @JsonIgnore
    @OneToMany (mappedBy = "signedBy",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<SampleResult> resultsSignedBy;
}
