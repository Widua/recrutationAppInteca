package me.widua.familymemberapp.repository;

import me.widua.familymemberapp.model.FamilyMemberModel;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyMemberRepository extends CrudRepository<FamilyMemberModel , Integer> {

    @Query( "SELECT * FROM families.familyMember WHERE familyId = :familyId" )
    Optional<List<FamilyMemberModel>> findFamilyMemberModelByFamilyId(Integer familyId) ;

    @Query( "SELECT * FROM families.familyMember WHERE familyId = :familyId" )
    Optional<List<FamilyMemberModel>> findFamilyMembersNeededDataByFamilyId(Integer familyId) ;


}
