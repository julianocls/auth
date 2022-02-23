package br.mg.jcls.auth.vo;

import br.mg.jcls.auth.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"username", "password"})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class UserVO extends RepresentationModel<UserVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private Integer password;

    public static UserVO create(User user) {
        return new ModelMapper().map(user, UserVO.class);
    }
}