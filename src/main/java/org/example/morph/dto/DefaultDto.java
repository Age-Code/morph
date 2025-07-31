package org.example.morph.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;

public class DefaultDto {

    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class BaseDto {
        String empty;

        public BaseDto afterBuild(BaseDto baseDto) {
            BeanUtils.copyProperties(baseDto, this);

            return this;
        }
    }

}
