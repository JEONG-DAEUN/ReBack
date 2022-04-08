package ReBack.core.data;

import lombok.Getter;

@Getter
public enum MemberType {

    ROLE_ADMIN("작가"), ROLE_MANAGER("업체"), ROLE_MEMBER("일반사용자");

    private String description;

    MemberType(String description) {
        this.description = description;
    }
}
