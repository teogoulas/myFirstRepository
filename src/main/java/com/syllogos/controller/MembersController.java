package com.syllogos.controller;

import com.syllogos.model.Member;
import com.syllogos.model.MemberView;
import com.syllogos.model.RodoClass;
import com.syllogos.service.MemberService;
import com.syllogos.service.RodoClassService;
import com.syllogos.service.RodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("member")
public class MembersController {

	@Autowired
	RodoService rodoService;

	@Autowired
	MemberService memberService;

	@Autowired
	RodoClassService rodoClassService;

	@ModelAttribute("memberId")
	public Long memberId(){
		return new Long(0);
	}

	@ModelAttribute("member")
	public Member createMember(){
		return new Member();
	}

	@RequestMapping(value = "addMember", method = RequestMethod.GET)
	public ModelAndView member(@RequestParam(value = "language", required = false) String locale, Model model, @ModelAttribute("memberId") Long memberId){
		rodoService.setGlobalLocale(locale);

		List<RodoClass> rodoClasses = rodoClassService.getAllRodoClasses();
		model.addAttribute("classes", rodoClasses);

		Member member = new Member();
		if (memberId != null && memberId != 0){
			member = memberService.getMemberById(memberId);
		}

		model.addAttribute("member",member);

		return new ModelAndView("addMember","command", member);
	}

	@RequestMapping(value = "addMember", method = RequestMethod.POST)
	public String saveMember(@ModelAttribute ("member") Member member){

		final String selectedClass =  member.getClassName();
		RodoClass selectedRodoClass = rodoClassService.getClassByName(selectedClass);
		if (selectedRodoClass != null) {
			member.setRodoClass(selectedRodoClass);
			memberService.saveMember(member);

			return "home";
		}else
			return "addmember";
	}
}
