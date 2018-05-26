package pl.edu.wat.share.cash.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.common.dto.base.BaseDto;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PersonGroupDto extends BaseDto<Long> {
    private Long personId;
    private Long groupId;
    private Integer percent;
}
