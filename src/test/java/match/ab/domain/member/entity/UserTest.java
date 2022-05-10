package match.ab.domain.member.entity;

import match.ab.domain.member.enums.RoleType;
import match.ab.domain.member.vo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {

    static final UserEmail USER_EMAIL = UserEmail.from("yim3370@gmail.com");
    static final UserPassword USER_PASSWORD = UserPassword.from("112233");
    static final RoleType ROLE_TYPE = RoleType.ENTERPRISE;
    static final UserName USER_NAME = UserName.from("임준희");
    static final UserNickName USER_NICK_NAME = UserNickName.from("chu-pop");
    static final UserAddress USER_ADDRESS = UserAddress.from("감일백제로");
    static final LocalDate USER_BIRTH = LocalDate.of(1999, 02, 05);
    static final UserImage USER_IMAGE = UserImage.from("/src/resources/abc.jpg");

    static User create(final UserEmail email, final UserPassword password, final RoleType roleType,
                       final UserName name, final UserNickName nickName, final UserAddress address,
                       final UserImage image, final LocalDate birth) {

        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .roleType(RoleType.ENTERPRISE)
                .nickName(nickName)
                .address(address)
                .birth(birth)
                .image(image)
                .build();
    }

    @Test @DisplayName("빌드 성공 테스트")
    void builderTest_success() {
        //given
        User user =
                create(USER_EMAIL, USER_PASSWORD, ROLE_TYPE, USER_NAME, USER_NICK_NAME,
                        USER_ADDRESS, USER_IMAGE, USER_BIRTH);
        //then
        assertThat(user.getEmail().userEmail()).isEqualTo("yim3370@gmail.com");
        assertThat(user.getPassword().userPassword()).isEqualTo("112233");
        assertThat(user.getRoleType()).isEqualTo(RoleType.ENTERPRISE);
        assertThat(user.getName().userName()).isEqualTo("임준희");
        assertThat(user.getNickName().userNickName()).isEqualTo("chu-pop");
        assertThat(user.getAddress().userAddress()).isEqualTo("감일백제로");
        assertThat(user.getImage().userImage()).isEqualTo("/src/resources/abc.jpg");
        assertThat(user.getBirth()).isEqualTo(LocalDate.of(1999, 02, 05));
    }
}
