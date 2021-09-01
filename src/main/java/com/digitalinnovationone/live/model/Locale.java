package com.digitalinnovationone.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private  long id;
    @ManyToOne
    private AccessLevel accessLevel;
    private String description;
}
