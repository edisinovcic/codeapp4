package com.eestec.codeapp.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.search.annotations.DocumentId;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;

@EqualsAndHashCode(exclude = {"id", "createdAt", "modifiedAt"})
@MappedSuperclass
@Data
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    @Valid
    protected Long id;

    @Column(name = "created_at")
    @JsonIgnore
    protected LocalDateTime createdAt;

    @Column(name = "modified_at")
    @JsonIgnore
    protected LocalDateTime modifiedAt;

    @PrePersist
    @PreUpdate
    protected void onPersist() {
        createdAt = LocalDateTime.now();
        modifiedAt = LocalDateTime.now();
    }

}
