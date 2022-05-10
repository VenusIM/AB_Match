package match.ab.domain.member.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class UserNickName {
    @NotBlank(message = "별칭은 필수 입력 사항입니다.")
    @Column(name = "user_nickname", nullable = false, length = 20)
    private String nickname;

    public static UserNickName form(final String nickname) {
        return new UserNickName(nickname);
    }

    public static UserNickName from(String nickname) {
        return new UserNickName(nickname);
    }

    @JsonValue
    public String userNickName() {
        return nickname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNickName());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        UserNickName userNickName = (UserNickName) obj;
        return Objects.equals(userNickName(), userNickName);
    }
}
