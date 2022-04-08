package ReBack.core.controller.request;

import ReBack.core.data.MemberType;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
public class RegistryRequest {
    private String memberId;

    private String memberPassword;

    private MemberType memberType = MemberType.ROLE_MEMBER;
}
