package knu.likelion12.BE_Session.domain.member.controller;

import jakarta.validation.Valid;
import knu.likelion12.BE_Session.domain.member.dto.request.RegisterRequest;
import knu.likelion12.BE_Session.domain.member.dto.response.MemberResponse;
import knu.likelion12.BE_Session.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping()
    public ResponseEntity<MemberResponse> register(@RequestBody @Valid RegisterRequest requestBody) {
        MemberResponse response = memberService.registerUser(requestBody);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
