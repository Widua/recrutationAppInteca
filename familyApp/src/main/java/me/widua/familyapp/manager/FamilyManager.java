package me.widua.familyapp.manager;

import me.widua.familyapp.model.AddAndGetFamilyModel;
import me.widua.familyapp.model.FamilyMemberModelComplete;
import me.widua.familyapp.model.FamilyModel;
import me.widua.familyapp.model.MemberModel;
import me.widua.familyapp.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
}