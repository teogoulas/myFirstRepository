package com.syllogos.service;

import com.syllogos.model.Member;
import com.syllogos.model.MemberView;

import java.util.List;

public interface MemberService {

	Member saveMember(Member member);

	List<MemberView> getMembersViewByClassName(String className);

	Member getMemberById(Long memberId);
}
