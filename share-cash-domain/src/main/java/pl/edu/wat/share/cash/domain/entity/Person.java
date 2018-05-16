package pl.edu.wat.share.cash.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.domain.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "T_PERSON")
@SequenceGenerator(name = "sPerson",
                   sequenceName = "SEQ_PERSON",
                   allocationSize = 1)
@NoArgsConstructor
public class Person extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "sPerson")
    @Id
    Long id;

}
