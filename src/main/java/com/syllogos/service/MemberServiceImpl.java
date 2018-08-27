package com.syllogos.service;

import com.syllogos.model.Member;
import com.syllogos.model.MemberView;
import com.syllogos.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	RodoClassService rodoClassService;

	@Override
	@Transactional
	public Member saveMember(Member member) {
		Integer memberCount = member.getRodoClass().getMemberCount();
		memberCount++;
		member.getRodoClass().setMemberCount(memberCount);
		//TODO: UPDATE SELECTED RODO CLASS SO AS TO STORE THE NEW MEMBER COUNT NUMBER
		return memberRepository.save(member);
	}

	@Override
	public List<MemberView> getMembersViewByClassName(String className) {
		return memberRepository.loadView(className);
	}

	@Override
	public Member getMemberById(Long memberId) {
		return memberRepository.load(memberId);
	}
}
