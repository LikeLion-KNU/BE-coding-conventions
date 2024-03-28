package knu.likelion12.BE_Session.domain.auth.service;

import knu.likelion12.BE_Session.domain.auth.dto.request.LoginRequest;
import knu.likelion12.BE_Session.domain.auth.dto.response.LoginResponse;
import knu.likelion12.BE_Session.domain.auth.dto.response.Token;
import knu.likelion12.BE_Session.domain.member.entity.Member;
import knu.likelion12.BE_Session.global.security.details.PrincipalDetails;
import knu.likelion12.BE_Session.global.security.provider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

        Authentication authentication = authenticationManagerBuilder
                .getObject()
                .authenticate(authenticationToken);

        Member member = ((PrincipalDetails) authentication.getPrincipal()).member();
        Token token = jwtTokenProvider.generateToken(authentication);

        return LoginResponse.from(member, token);
    }
}
