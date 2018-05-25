package pl.edu.wat.share.cash.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.common.enums.CreditCardProviderEnum;
import pl.edu.wat.share.cash.domain.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Kamil Przyborowski, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "T_CREDIT_CARD")
@SequenceGenerator(name = "sCreditCard",
        sequenceName = "SEQ_CREDIT_CARD",
        allocationSize = 1)
@NoArgsConstructor
public class CreditCard extends BaseEntity {


    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "sCreditCard")
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    Person owner;

    @Column
    @Enumerated(EnumType.STRING)
    CreditCardProviderEnum provider;

    @Column
    String cardNumber;

    @Column
    String ownerName;

    @Column
    String ownerAddress;

    @Column
    String country;

    @Column
    String csc;

    @Column
    Date exp;

}
