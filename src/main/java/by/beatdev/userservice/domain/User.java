package by.beatdev.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Objects;
/**
 * User is the main entity of application.
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    /**
     * Email of user
     */
    @Column(name = "email")
    private String email;

    /**
     * Full name of user
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * Uri of users avatar
     */
    @Column(name = "image_uri", columnDefinition = "text")
    private String imageUri;

    /**
     * User status
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    /**
     * User password
     */
    @Column(name = "password")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email)
                && Objects.equals(fullName, user.fullName)
                && Objects.equals(imageUri, user.imageUri)
                && status == user.status
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, fullName, imageUri, status, password);
    }
}
