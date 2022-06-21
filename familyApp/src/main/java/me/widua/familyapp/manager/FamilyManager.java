package me.widua.familyapp.manager;

import me.widua.familyapp.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamilyManager {
    private final FamilyRepository repository ;

    @Autowired
    public FamilyManager (FamilyRepository repository){
        this.repository = repository ;
    }



}
