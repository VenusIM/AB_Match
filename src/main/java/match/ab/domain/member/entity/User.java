package match.ab.domain.member.entity;

import match.ab.domain.member.enums.RoleType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import match.ab.domain.member.vo.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Embedded
    private UserEmail email;

    @Embedded
    private UserPassword password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", length = 10)
    private RoleType roleType;

    @Embedded
    private UserName name;

    @Embedded
    private UserNickName nickName;

    @Embedded
    private UserAddress address;

    @Embedded
    private UserImage image;

    @DateTimeFormat
    private LocalDate birth;

    @Builder
    public User(UserEmail email, UserPassword password, RoleType roleType, UserName name,
                UserNickName nickName, UserAddress address, UserImage image, LocalDate birth) {
        this.email = email;
        this.password = password;
        this.roleType = roleType;
        this.name = name;
        this.nickName = nickName;
        this.address = address;
        this.image = image;
        this.birth = birth;
    }


}
