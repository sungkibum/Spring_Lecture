package inhatc.spring.shop.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MemberFormDto {
    private String name;
    private String email;
    private String password;
    private String address;
}