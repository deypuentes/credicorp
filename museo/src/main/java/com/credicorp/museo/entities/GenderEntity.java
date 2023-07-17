package com.credicorp.museo.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="t_gender_visitor")
public class GenderEntity {

    @Id
    @Column(name="id_label")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLabel;

    @Column(name= "gender")
    private String gender;

    @Column(name="storage_date")
    private LocalDate storageDate;


}
