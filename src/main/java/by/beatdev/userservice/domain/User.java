package by.beatdev.userservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time_create")
    private LocalDateTime dateTimeCreate;

    @Column(name = "date_time_update")
    private LocalDateTime dateTimeUpdate;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "image_uri")
    private String imageUri;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "password")
    private String password;

    @PrePersist
    void initDateCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.dateTimeCreate = now;
        this.dateTimeUpdate = now;
    }
}
