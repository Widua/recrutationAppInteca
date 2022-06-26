package me.widua.familyapp.api;

import me.widua.familyapp.manager.FamilyManager;
import me.widua.familyapp.model.AddAndGetFamilyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class FamilyAPI {

    private final FamilyManager manager ;

    @Autowired
    public FamilyAPI(FamilyManager manager){
        this.manager = manager ;
    }

    @GetMapping("/getFamily/{familyNumber}")
    public ResponseEntity<AddAndGetFamilyModel> getFamily(@PathVariable int familyNumber){
        return null ;
    }

    @PostMapping("/addFamily")
    public ResponseEntity<String> addFamily(@RequestBody AddAndGetFamilyModel addModel ){
        return manager.addFamily(addModel) ;
    }




}
