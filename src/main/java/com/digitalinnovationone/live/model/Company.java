package com.digitalinnovationone.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Company {
    @Id
    private Long id;
    private String description;
    private String cnpj;
    private String address;
    private String district;
    private String city;
    private String state;
    private String phone;
}
