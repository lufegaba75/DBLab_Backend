package com.lufegaba.datalab.model.entities.results;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.users.Worker;
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
public class SampleResult {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "sample_id", referencedColumnName = "id", nullable = false)
    private Sample sample;

    private LocalDateTime reportDate;

    @ManyToOne
    @JoinColumn (name = "signedBy", referencedColumnName = "id")
    private Worker signedBy;

    @JsonIgnore
    @OneToMany (mappedBy = "sampleResult",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<ResultDetails> resultDetailsList;
}
