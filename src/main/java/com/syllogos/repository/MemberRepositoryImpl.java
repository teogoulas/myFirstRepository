package com.syllogos.repository;

import com.syllogos.model.Member;
import com.syllogos.model.MemberView;
import com.syllogos.model.RodoClass;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("memberRepository")
public class MemberRepositoryImpl implements MemberRepository {

	@PersistenceContext
	private EntityManager em;


	@Override
	public Member save(Member member) {

		if (member.getId() == null){
			em.persist(member);
			em.flush();
		}else {
			member = em.merge(member);
		}
		return member;
	}

	@Override
	public List<MemberView> loadView(String className) {
		TypedQuery<MemberView> query = em.createNamedQuery(RodoClass.GET_RODOCLASS_MEMBERS_VIEW, MemberView.class);
		query.setParameter("className", className);

		return query.getResultList();
	}

	@Override
	public Member load(Long memberId) {
		TypedQuery<Member> query = em.createNamedQuery(Member.GET_MEMBER_BY_ID, Member.class);
		query.setParameter("memberId", memberId);

		return query.getSingleResult();
	}
}
