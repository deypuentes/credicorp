package com.credicorp.museo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="t_gender_visitor")
public class VisitorTotalEntity {

    @Id
    @Column(name="id_label")
    private Integer idLabel;

    @Column(name= "gender")
    private String gender;

    public VisitorTotalEntity(String gender) {
        this.gender = gender;
    }
}
