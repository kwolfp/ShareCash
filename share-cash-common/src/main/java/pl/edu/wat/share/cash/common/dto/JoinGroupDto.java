package pl.edu.wat.share.cash.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinGroupDto {
    private Long personId;
    private Integer password;
}
