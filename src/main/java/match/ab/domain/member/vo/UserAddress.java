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
public class UserAddress {
    @NotBlank(message = "주소는 필수 입력 사항입니다.")
    @Column(name = "user_address", nullable = false, length = 100)
    private String address;

    public static UserAddress from(final String address) {
        return new UserAddress(address);
    }

    @JsonValue
    public String userAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userAddress());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        UserAddress userAddress = (UserAddress) obj;
        return Objects.equals(userAddress(), userAddress.address);
    }
}
