package pl.edu.wat.share.cash.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.common.dto.base.BaseDto;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PersonDto extends BaseDto<Long> {

    private String name;
    private String lastName;

}
