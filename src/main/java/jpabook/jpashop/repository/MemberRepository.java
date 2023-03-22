package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    //select m from Member m where m.name = :name
    List<Member> findByName(String name);

    List<Member> findByLoginId(String loginid);
}
