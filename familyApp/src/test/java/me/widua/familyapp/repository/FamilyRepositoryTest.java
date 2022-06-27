package me.widua.familyapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource(properties = "spring.datasource.url=jdbc:mariadb://localhost:3306/families")
class FamilyRepositoryTest {

    @Autowired
    private FamilyRepository underTest ;


    @Test
    public void returnFamilyIdByFamilyNameTest(){
        assertEquals( 1 , underTest.getFamilyIdByFamilyName("Raynolds").get() );
    }



}