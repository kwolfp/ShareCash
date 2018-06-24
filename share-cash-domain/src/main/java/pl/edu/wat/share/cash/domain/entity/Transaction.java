package pl.edu.wat.share.cash.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.domain.entity.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "T_Transaction")
@SequenceGenerator(name = "sTransaction",
        sequenceName = "SEQ_Transaction",
        allocationSize = 1)
@NoArgsConstructor
public class Transaction extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "sTransaction")
    @Id
    Long id;

    @Column
    String name;

    @Column
    BigDecimal amount;

    @Column
    String adress;

    @Column
    Long accNumber;

    @ManyToOne
    @JoinColumn(name = "groupId")
    Group payer;

    @Column
    Date transactionDate;

    @Column
    Double latitude;

    @Column
    Double longitude;

    @Column
    String transactionAddress;
}
