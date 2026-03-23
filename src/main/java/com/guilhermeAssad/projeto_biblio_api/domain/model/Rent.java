package com.guilhermeAssad.projeto_biblio_api.domain.model;


import com.guilhermeAssad.projeto_biblio_api.utils.ERentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TABLE_RENT")
@EqualsAndHashCode(of = "id")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    @Column(name = "STATUS_RENT")
    @Enumerated(EnumType.STRING)
    private ERentStatus status;

    @Column(name = "DATE_RENT")
    private LocalDateTime dateRent;

    @Column(name = "DATE_RETURN")
    private LocalDateTime dateReturn;

    @PrePersist
    public void prePersistDate(){
        this.dateRent=LocalDateTime.now();
    }

}
