package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null이면 로그인 실패
     */
    public Member login(String loginId, String password) {

        List<Member> byLoginId = memberRepository.findByLoginId(loginId);

        if (byLoginId.get(0).getPassword().equals(password)) {
            return byLoginId.get(0);
        }else {
            return null;
        }

    }
}