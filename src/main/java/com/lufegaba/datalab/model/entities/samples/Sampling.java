package com.lufegaba.datalab.model.entities.samples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lufegaba.datalab.model.entities.clients.Client;
import com.lufegaba.datalab.model.entities.users.Worker;
import com.lufegaba.datalab.model.entities.enumerations.SamplingObjective;
import com.lufegaba.datalab.model.entities.enumerations.SamplingType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sampling {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name="client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name="worker_id", referencedColumnName = "id")
    private Worker worker;

    @Column
    @Temporal(TemporalType.DATE)
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
