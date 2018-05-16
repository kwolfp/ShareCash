package pl.edu.wat.share.cash.domain.entity.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

}
