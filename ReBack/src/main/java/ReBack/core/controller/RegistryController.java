package ReBack.core.controller;

import ReBack.core.controller.request.RegistryRequest;
import ReBack.core.data.Member;
import ReBack.core.data.MemberType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@Controller
public class RegistryController {

    private final ReBack.core.repository.MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/registry")
    public String registryForm(Model model) {
        model.addAttribute("member", new RegistryRequest());
        return "registration";
    }

    @PostMapping("/registry")
    public String registry(@ModelAttribute RegistryRequest registryRequest) {
        Member member = Member.builder()
                .memberId(registryRequest.getMemberId())
                .memberPassword(passwordEncoder.encode(registryRequest.getMemberPassword()))
                .memberType(registryRequest.getMemberType())
                .build();
        memberRepository.save(member);

        return "redirect:/login";
    }

    @ModelAttribute("roles")
    public Map<String, MemberType> roles() {
        Map<String, MemberType> map = new LinkedHashMap<>();
        map.put("작가", MemberType.ROLE_ADMIN);
        map.put("업체", MemberType.ROLE_MANAGER);
        map.put("일반 사용자", MemberType.ROLE_MEMBER);
        return map;
    }
}
