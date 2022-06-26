package me.widua.familyapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("family")
public class FamilyModel {
    @Id
    @Column("id")
    private int id ;
    @Column("familyName")
    private String familyName ;
    @Column("nrOfAdults")
    private int nrOfAdults ;
    @Column("nrOfChildren")
    private int nrOfChildren ;
    @Column("nrOfInfants")
    private int nrOfInfants ;

}
