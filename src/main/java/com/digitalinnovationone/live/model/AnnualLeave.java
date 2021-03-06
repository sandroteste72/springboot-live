package com.digitalinnovationone.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class AnnualLeave {

    @Embeddable
    @Getter
    @Setter
    @EqualsAndHashCode
    public class AnnualLeaveId implements Serializable {
        private long annualLeaveId;
        private long movementId;
        private long userId;
    }
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private AnnualLeaveId annualLeaveId;
    private LocalDateTime dateWorked;
    private BigDecimal amountHours;
    private BigDecimal balanceHours;
}
