package com.syllogos.repository;

import com.syllogos.model.Member;
import com.syllogos.model.MemberView;

import java.util.List;

public interface MemberRepository {

	Member save(Member member);

	List<MemberView> loadView(String className);

	Member load(Long memberId);
}
