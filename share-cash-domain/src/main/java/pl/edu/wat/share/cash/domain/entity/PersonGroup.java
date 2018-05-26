package pl.edu.wat.share.cash.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.domain.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "T_PERSON_GROUP")
@SequenceGenerator(name = "sPersonGroup",
                   sequenceName = "SEQ_PERSON_GROUP",
                   allocationSize = 1)
@NoArgsConstructor
public class PersonGroup extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "sPersonGroup")
    @Id
    Long id;


    @ManyToOne
    @JoinColumn(name = "personId")
    Person person;

    @ManyToOne
    @JoinColumn(name = "groupId")
    Group group;

    @Column
    Integer percent;

}
