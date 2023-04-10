package by.beatdev.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time_create")
    private LocalDateTime dateTimeCreate;

    @Column(name = "date_time_update")
    private LocalDateTime dateTimeUpdate;

    @PrePersist
    void initDateCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.dateTimeCreate = now;
        this.dateTimeUpdate = now;
    }

    @PreUpdate
    void updateDateTimeUpdate() {
        this.dateTimeUpdate = LocalDateTime.now();
    }
}
