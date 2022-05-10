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
public class UserName {

    @NotBlank(message = "이름은 필수 입력 사항입니다.")
    @Column(name = "user_name", nullable = false, length = 20)
    private String name;

    public static UserName from(final String name) {
        return new UserName(name);
    }

    @JsonValue
    public String userName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        UserName userName = (UserName) obj;
        return Objects.equals(userName(), userName.name);
    }
}
