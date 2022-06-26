package me.widua.familymemberapp.api;

import me.widua.familymemberapp.manager.FamilyMemberManager;
import me.widua.familymemberapp.model.FamilyMemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FamilyMemberAPI {

    private final FamilyMemberManager manager ;

    @Autowired
    public FamilyMemberAPI(FamilyMemberManager manager){
        this.manager = manager ;
    }

    @GetMapping("/searchMember/{id}")
    public ResponseEntity<FamilyMemberModel> searchFamilyMember(@PathVariable int id){
        return manager.searchFamilyMember(id) ;
    }

    @PostMapping("/addMember")
    public ResponseEntity<String> addFamilyMember( @RequestBody FamilyMemberModel familyMember ){
        return manager.createFamilyMember(familyMember) ;
    }



}
