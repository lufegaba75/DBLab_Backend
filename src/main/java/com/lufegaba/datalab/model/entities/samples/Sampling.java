package com.lufegaba.datalab.model.entities.samples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.users.Worker;
import com.lufegaba.datalab.model.entities.enumerations.SamplingObjective;
import com.lufegaba.datalab.model.entities.enumerations.SamplingType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sampling {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;

    @NotNull
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name="sampling_id", referencedColumnName = "id", nullable=false)
    private Client client;

    @NotNull
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name="worker_id", referencedColumnName = "id", nullable = false)
    private Worker worker;

    private LocalDate samplingDate;
    private LocalDateTime createdAt;

    private SamplingObjective samplingObjective;

    private SamplingType samplingType;

    @JsonIgnore
    @OneToMany(mappedBy = "sampling",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Sample> sampleList;

}
