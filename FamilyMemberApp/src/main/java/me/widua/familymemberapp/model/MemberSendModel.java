package me.widua.familymemberapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSendModel {

    private String givenName ;
    private Integer age ;

}
