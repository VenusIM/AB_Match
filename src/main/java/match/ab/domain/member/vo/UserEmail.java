package match.ab.domain.member.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class UserEmail {
    @Email
    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    @Column(name = "user_email", unique = true, nullable = false, length = 40)
    private String email;

    public static UserEmail from(final String email) {
        return new UserEmail(email);
    }

    @JsonValue
    public String userEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail());
    }

    @Override
    // 논리적 동일성 비교
    public boolean equals(Object obj) {
        //reference compare
        if (this == obj) return true;
        //Transitive 추이성
        if (obj == null || getClass() != obj.getClass()) return false;
        UserEmail userEmail = (UserEmail) obj;
        return Objects.equals(userEmail(), userEmail.email);
    }
}
