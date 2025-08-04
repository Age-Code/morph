package org.example.morph.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.morph.domain.RoleUser;

import java.time.LocalDateTime;
import java.util.List;

public class RoleUserDto {

    // Add Service Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class AddSevDto{
        Long roleId;
        Long userId;

        Long reqUserId;

        public RoleUser toEntity() { return RoleUser.of(getRoleId(), getUserId(), getReqUserId()); }
    }

    // Add Response Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class AddResDto {
        Long id;
    }

    // AddUser Request Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class AddUserReqDto extends DefaultDto.BaseDto {
        List<RoleUserDto.AddSevDto> addSevDtoList;
    }

    // AddUser Service Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class AddUserSevDto extends AddUserReqDto {
        Long reqUserId;
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

    // AddList Request Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UserListReqDto extends DefaultDto.BaseDto {
        Long roleId;
        Boolean deleted;
    }

    // AddList Service Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UserListSevDto extends UserListReqDto {
        Long reqUserId;
    }

    // AddList Response Dto
    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UserListResDto {
        Long userId;
        String username;
    }

}
