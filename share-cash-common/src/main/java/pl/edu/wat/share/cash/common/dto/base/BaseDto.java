package pl.edu.wat.share.cash.common.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto<I extends Serializable> {
    I id;
}
