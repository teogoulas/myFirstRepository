package com.syllogos.controller;

import com.syllogos.model.MemberView;
import com.syllogos.model.RodoClass;
import com.syllogos.model.RodoClassView;
import com.syllogos.service.MemberService;
import com.syllogos.service.RodoClassService;
import com.syllogos.service.RodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes(value = "class")
public class ClassesController {

	@Autowired
	private RodoService rodoService;

	@Autowired
	private RodoClassService rodoClassService;

	@Autowired
	private MemberService memberService;


	@ModelAttribute("class")
	public RodoClass createRodoClassModel(){
		return new RodoClass();
	}

	@RequestMapping(value = "classes", method = RequestMethod.GET)
	public ModelAndView rodoClass(@RequestParam(value = "language", required = false) String locale, Model model){
		rodoService.setGlobalLocale(locale);

		List<RodoClass> rodoClasses = rodoClassService.getAllRodoClasses();
		model.addAttribute("classes", rodoClasses);

		return new ModelAndView("classes", "command", new RodoClass());
	}

	@RequestMapping(value = "classes", method = RequestMethod.POST)
	public String getClass(@ModelAttribute("class") RodoClass rodoClass, Model model, RedirectAttributes redirectAttributes){

		RodoClassView rodoClassView =  rodoClassService.getClassViewByName(rodoClass.getClassName());
		model.addAttribute("classView", rodoClassView);

		List<MemberView> members = memberService.getMembersViewByClassName(rodoClass.getClassName());
		model.addAttribute("memberView",members);

		redirectAttributes.addFlashAttribute("memberView", members);
		return "classOverview";

	}

	@RequestMapping(value = "classOverview", method = RequestMethod.GET)
	public String renderClass (@ModelAttribute("class") RodoClass rodoClass, Model model, @RequestParam(value = "language", required = false) String locale){
		rodoService.setGlobalLocale(locale);

		RodoClassView rodoClassView =  rodoClassService.getClassViewByName(rodoClass.getClassName());
		model.addAttribute("classView", rodoClassView);

		return "classOverview";
	}

	@RequestMapping(value = "classOverview", method = RequestMethod.POST)
	public String returnToHome (@ModelAttribute("class") RodoClass rodoClass){
		return "redirect:classes.html";
	}

	@RequestMapping(value = "addClass", method = RequestMethod.GET)
	public ModelAndView newRodoClass(@RequestParam(value = "language", required = false) String locale){
		rodoService.setGlobalLocale(locale);

		return new ModelAndView("addClass", "command", new RodoClass());
	}

	@RequestMapping(value = "addClass", method = RequestMethod.POST)
	public String saveNewRodoClass (@ModelAttribute("class") RodoClass rodoClass){

		rodoClassService.saveRodoClass(rodoClass);

		return "home";
	}

	@RequestMapping(value = "editMember")
	public String editMember(@RequestParam(value = "memberId", required = false) Long studentId, RedirectAttributes redirectAttributes){

		redirectAttributes.addFlashAttribute("memberId", studentId);
		return "redirect:addMember.html";
	}
}
