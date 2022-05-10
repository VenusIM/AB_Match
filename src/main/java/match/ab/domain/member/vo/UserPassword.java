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
public class UserPassword {
    @NotBlank(message = "비밀번호는 필수 입력 사항입니다.")
    @Column(name = "user_password", nullable = false, length = 100)
    private String password;

    public static UserPassword from(final String password) {
        return new UserPassword(password);
    }

    @JsonValue
    public String userPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userPassword());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        UserPassword userPassword = (UserPassword) obj;
        return Objects.equals(userPassword(), userPassword.password);
    }
}
