package org.example.library.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TakenBooks {
    @Id
    private Long id;
    @ManyToOne
    private Book book;
    @ManyToOne
    private User user;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
