package knu.likelion12.BE_Session.domain.member.service;

import knu.likelion12.BE_Session.domain.member.dto.request.RegisterRequest;
import knu.likelion12.BE_Session.domain.member.dto.response.MemberResponse;
import knu.likelion12.BE_Session.domain.member.entity.Member;
import knu.likelion12.BE_Session.domain.member.entity.Role;
import knu.likelion12.BE_Session.domain.member.repository.MemberRepository;
import knu.likelion12.BE_Session.global.exception.GlobalException;
import knu.likelion12.BE_Session.global.util.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new GlobalException(HttpStatus.NOT_FOUND, "Not Found Member"));
    }

    public boolean existMemberByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    public MemberResponse registerUser(RegisterRequest request) {
        if (existMemberByEmail(request.email())) {
            throw new GlobalException(HttpStatus.BAD_REQUEST, "Duplicated Email");
        }

        if (PasswordValidator.validatePassword(request.password())) {
            throw new GlobalException(HttpStatus.BAD_REQUEST, "Password must be 8-20 characters long and include uppercase letters, lowercase letters, numbers, and special characters.");
        }

        Member member = request.toEntity(passwordEncoder, Role.ROLE_USER);
        Member savedMember = memberRepository.save(member);

        return MemberResponse.from(savedMember);
    }
}
