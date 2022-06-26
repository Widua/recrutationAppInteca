package me.widua.familymemberapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "familyMember")
public class FamilyMemberModel {

    @Id
    @Column("id")
    private Integer id ;
    @Column("familyId")
    private Integer familyId ;
    @Column("givenName")
    private String givenName ;
    @Column("age")
    private Integer age ;

}
