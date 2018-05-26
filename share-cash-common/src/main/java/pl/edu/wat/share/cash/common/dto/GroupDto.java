package pl.edu.wat.share.cash.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.edu.wat.share.cash.common.dto.base.BaseDto;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupDto extends BaseDto<Long> {
    private Long ownerId;
    private String name;
    private Integer password;
    private Date creationDate;


    
}
