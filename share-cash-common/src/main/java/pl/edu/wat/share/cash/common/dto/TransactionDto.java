package pl.edu.wat.share.cash.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.common.dto.base.BaseDto;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto extends BaseDto<Long> {
    private Long payerId;
    private String name;
    private BigDecimal amount;
    private String adress;
    private Long accNumber;
    private Date transactionDate;
}
