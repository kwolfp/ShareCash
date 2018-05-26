package pl.edu.wat.share.cash.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.domain.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

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

    @Column
    Date creationDate;


}
