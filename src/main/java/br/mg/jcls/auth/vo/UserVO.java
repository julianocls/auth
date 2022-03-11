package br.mg.jcls.auth.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserVO implements Serializable {

    private static final long serialVersionUID = -8387927312441830960L;

    private String userName;
    private String password;

}