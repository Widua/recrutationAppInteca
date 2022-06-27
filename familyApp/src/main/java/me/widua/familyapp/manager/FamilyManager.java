package me.widua.familyapp.manager;

import me.widua.familyapp.model.*;
import me.widua.familyapp.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class FamilyManager {
    private final FamilyRepository repository ;
    private final RestTemplate restTemplate = new RestTemplate() ;

    @Autowired
    public FamilyManager (FamilyRepository repository){
        this.repository = repository ;
    }

    public ResponseEntity<String> addFamily(AddAndGetFamilyModel addModel){
        if (!addModel.isValid()){
            return ResponseEntity.badRequest().body("Bad age range provided!") ;
        }

        FamilyModel family = FamilyModel.builder()
                .familyName(addModel.getFamilyName())
                .nrOfAdults(addModel.getNrOfAdults())
                .nrOfChildren(addModel.getNrOfChildren())
                .nrOfInfants(addModel.getNrOfInfants())
                .build();
        repository.save(family);
        Integer familyId = repository.getFamilyIdByFamilyName(addModel.getFamilyName()).get();
        List<MemberModel> members = addModel.getFamilyMembers() ;

        members.stream()
                        .map( member -> FamilyMemberModelComplete.builder()
                                .age(member.getAge())
                                .givenName(member.getGivenName())
                                .familyId(familyId)
                                .build()
                        ).forEach( toSend -> restTemplate.postForObject("http://familyMemberApp:8081/api/addMember",toSend,
                        String.class));



        return ResponseEntity.ok("This family, will have id: "+familyId);
    }

    public ResponseEntity<AddAndGetFamilyModel> getFamily(Integer familyId){
        Optional<FamilyModel> familyOptional = repository.findById(familyId) ;
        if (familyOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        FamilyModel family = familyOptional.get() ;

        MemberModel[] familyMembers = restTemplate.getForObject(
                "http://familyMemberApp:8081/api/searchMembers/{familyId}" ,
                MemberModel[].class ,
                familyId) ;

        AddAndGetFamilyModel getFamily = AddAndGetFamilyModel.builder()
                .familyMembers(List.of(familyMembers))
                .familyName(family.getFamilyName())
                .nrOfAdults(family.getNrOfAdults())
                .nrOfChildren(family.getNrOfChildren())
                .nrOfInfants(family.getNrOfInfants())
                .build() ;
        return ResponseEntity.ok(getFamily) ;
    }
}