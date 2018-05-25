package pl.edu.wat.share.cash.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.common.dto.base.BaseDto;
import pl.edu.wat.share.cash.common.enums.CreditCardProviderEnum;

import java.util.Date;

/**
 * Created by Kamil Przyborowski, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreditCardDto extends BaseDto<Long> {
    private Long ownerId;
    private CreditCardProviderEnum provider;
    private String cardNumber;
    private String ownerName;
    private String ownerAddress;
    private String country;
    private String csc;
    private Date exp;
}
