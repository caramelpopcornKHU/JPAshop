package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    // 단건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 전부 조회
    public List<Member> findAll() {
        String query = "select m from Member m";
        return em.createQuery(query, Member.class).getResultList();
    }

    // 이름으로 조회
    public List<Member> findByName(String name) {
        String query = "select m from Member m where m.name = :name";
        return em.createQuery(query, Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
