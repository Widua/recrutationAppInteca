package me.widua.familyapp.repository;

import me.widua.familyapp.model.FamilyModel;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamilyRepository extends CrudRepository<FamilyModel , Integer> {

    @Query("SELECT id FROM families.family WHERE familyName = :familyName;")
    Optional<Integer> getFamilyIdByFamilyName(String familyName) ;

}
