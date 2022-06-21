package me.widua.familyapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class FamilyModel {
    @Id
    private int id ;
    private String familyName ;
    private int nrOfAdults ;
    private int nrOfChildren ;
    private int nrOfInfants ;

}
