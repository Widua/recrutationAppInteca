package me.widua.familyapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AddAndGetFamilyModel {

    private String familyName ;
    private Integer nrOfAdults ;
    private Integer nrOfChildren ;
    private Integer nrOfInfants ;
    private List<MemberModel> familyMembers ;

    @JsonIgnore
    public boolean isValid(){
        int infants = familyMembers.stream().filter((member) -> member.getAge() <= 4).toList().size();
        int children = familyMembers.stream().filter( (member) -> member.getAge() > 4 && member.getAge() < 16 ).toList().size();
        int adults = familyMembers.stream().filter( (member) -> member.getAge() >= 16 ).toList().size() ;
        return nrOfAdults == adults && nrOfChildren == children && nrOfInfants == infants ;
    }
}
