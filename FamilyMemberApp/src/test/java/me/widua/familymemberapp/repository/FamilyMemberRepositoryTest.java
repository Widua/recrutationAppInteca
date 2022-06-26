package me.widua.familymemberapp.repository;

import me.widua.familymemberapp.model.FamilyMemberModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = "spring.datasource.url=jdbc:mariadb://localhost:3306/families")
class FamilyMemberRepositoryTest {

    @Autowired
    private FamilyMemberRepository underTest ;

    @Test
    public void returnFamilyMembersTest(){
        Optional<List<FamilyMemberModel>> familyMembers = underTest.findFamilyMemberModelByFamilyId(1) ;
        assertEquals(5,familyMembers.get().size());
    }

    @Test
    public void shouldReturnEmpty(){
        assertEquals(0 , underTest.findFamilyMemberModelByFamilyId(2).get().size() );
    }

}