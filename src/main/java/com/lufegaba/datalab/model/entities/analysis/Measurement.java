package com.lufegaba.datalab.model.entities.analysis;

import com.lufegaba.datalab.model.entities.users.Worker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private Double measurement;
    private String annotation;

    private LocalDateTime measurementDate;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "analysisorderdetails_id", referencedColumnName = "id")
    private AnalysisOrderDetails analysisOrderDetail;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn (name = "analyst_id", referencedColumnName = "id")
    private Worker analyst;


}
