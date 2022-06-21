package me.widua.familyapp.repository;

import me.widua.familyapp.model.FamilyModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FamilyRepository extends CrudRepository<FamilyModel , Integer> {

    @Override
    Optional<FamilyModel> findById(Integer integer);

    Optional<FamilyModel> getFamilyModelByFamilyName(String familyName) ;
}
