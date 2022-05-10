package match.ab.domain.member.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class UserImage {
    @Column(name = "user_image")
    private String image;

    public static UserImage from(final String image) {
        return new UserImage(image);
    }

    @JsonValue
    public String userImage() {
        return image;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userImage());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        UserImage userImage = (UserImage) obj;
        return Objects.equals(userImage(), userImage.image);
    }
}
