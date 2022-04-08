package ReBack.core.controller.request;

import ReBack.core.data.MemberType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String memberId;

    private String memberPassword;

    private MemberType memberType;
}
