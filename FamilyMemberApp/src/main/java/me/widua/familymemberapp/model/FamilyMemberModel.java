package me.widua.familymemberapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class FamilyMemberModel {

    @Id
    private int id ;

    private int familyId ;
    private String familyName ;
    private String givenName ;


}
