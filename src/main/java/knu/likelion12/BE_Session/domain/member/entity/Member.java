package knu.likelion12.BE_Session.domain.member.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import knu.likelion12.BE_Session.domain.team.entity.TeamMember;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "name")
    private String name;

    @Column(name = "expired")
    private boolean isAccountExpired;

    @Column(name = "locked")
    private boolean isAccountLocked;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMember> teamMembers = new ArrayList<>();

    @Builder
    public Member(String email, String password, Role role, String name, boolean isAccountExpired, boolean isAccountLocked) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.isAccountExpired = isAccountExpired;
        this.isAccountLocked = isAccountLocked;
    }
}
