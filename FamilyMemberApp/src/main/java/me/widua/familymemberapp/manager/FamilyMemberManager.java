package me.widua.familymemberapp.manager;


import me.widua.familymemberapp.model.FamilyMemberModel;
import me.widua.familymemberapp.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FamilyMemberManager {

    private final FamilyMemberRepository repository ;

    @Autowired
    public FamilyMemberManager(FamilyMemberRepository repository){
        this.repository = repository ;
    }

    public ResponseEntity<FamilyMemberModel> searchFamilyMember(Integer memberId) {
        Optional<FamilyMemberModel> memberOptional = repository.findById(memberId) ;
        return memberOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<String> createFamilyMember(FamilyMemberModel member){
        repository.save(member) ;
        return ResponseEntity.ok(member.toString()) ;
    }


}
