package pl.edu.wat.share.cash.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.domain.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.domain.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Kamil Przyborowski, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "T_Group")
@SequenceGenerator(name = "sGroup",
        sequenceName = "SEQ_Group",
        allocationSize = 1)
@NoArgsConstructor
public class Group extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "sGroup")
    @Id
    Long id;

    @Column
    String name;

    @Column
    Integer password;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    Person owner;

    @OneToMany(mappedBy = "payer")
    List<Transaction> transactions;

    @Column
    Date creationDate;

    @OneToMany(mappedBy = "group")
    List<PersonGroup> members;

}
