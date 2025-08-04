package org.example.morph.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.morph.domain.RoleUser;

import java.time.LocalDateTime;

public class RoleUserDto {

    // Add Request Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class AddReqDto extends DefaultDto.BaseDto {
        Long roleId;
        Long userId;
    }

    // Add Service Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class AddSevDto extends RoleUserDto.AddReqDto {
        Long reqUserId;

        public RoleUser toEntity() { return RoleUser.of(getRoleId(), getUserId(), getReqUserId()); }
    }

    // Add Response Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class AddResDto {
        Long id;
    }

    // List Service Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListSevDto {
        Long roleId;
        Boolean deleted;

        Long reqUserId;
    }

    // List Response Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListResDto {
        Long userId;
        String username;
        Boolean userDeleted;
        Long addUserId;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDateTime addedAt;
    }

}
