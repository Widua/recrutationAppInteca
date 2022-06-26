package me.widua.familyapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FamilyMemberModelComplete {

    private Integer familyId ;
    private String givenName ;
    private Integer age ;

}
