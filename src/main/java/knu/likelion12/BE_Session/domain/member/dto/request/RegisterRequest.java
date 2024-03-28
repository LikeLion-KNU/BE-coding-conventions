package knu.likelion12.BE_Session.domain.member.dto.request;

import knu.likelion12.BE_Session.domain.member.entity.Member;
import knu.likelion12.BE_Session.domain.member.entity.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

public record RegisterRequest(
        String email, String password, String name
) {
    public Member toEntity(PasswordEncoder passwordEncoder, Role role) {
        return Member.builder()
                .email(this.email)
                .password(passwordEncoder.encode(this.password))
                .role(role)
                .name(this.name)
                .isAccountExpired(false)
                .isAccountLocked(false)
                .build();
    }
}
