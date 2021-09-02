package com.digitalinnovationone.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Locale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @ManyToOne
    private AccessLevel accessLevel;
    private String description;
}
