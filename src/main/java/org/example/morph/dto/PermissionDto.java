package org.example.morph.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.morph.domain.Permission;

public class PermissionDto {

    // Toggle Request Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ToggleReqDto extends DefaultDto.BaseDto {
        Boolean active;
        Long roleId;
        String permission;
        Integer func;
    }

    // Toggle Service Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ToggleSevDto extends ToggleReqDto {
        Long reqUserId;

        public Permission toEntity() { return Permission.of(getRoleId(), getPermission(), getFunc()); }
    }

    // Toggle Response Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ToggleResDto {
        Long id;
    }

}
