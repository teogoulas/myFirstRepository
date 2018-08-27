package com.syllogos.service;

import com.syllogos.model.GlobalVariables;
import com.syllogos.model.RodoClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("rodoClassesService")
public class RodoServiceImpl implements RodoService {

	public ArrayList<RodoClass> getAllRodoClasses(){
		ArrayList<RodoClass> rodoClasses = new ArrayList<RodoClass>();
		Long idCount = Long.valueOf(0);

		RodoClass beginners = new RodoClass();
		beginners.setId(idCount);
		beginners.setClassName("Beginners");
		beginners.setDay("Monday");
		beginners.setTutorName("Panagiotis Spirou");
		beginners.setTime("18:00:00");
		beginners.setDuration(60);
		beginners.setMemberCount(0);
		rodoClasses.add(beginners);

		RodoClass Experts = new RodoClass();
		Experts.setId(idCount++);
		Experts.setClassName("Experts");
		Experts.setDay("Thursday");
		Experts.setTutorName("Panagiotis Spirou");
		Experts.setTime("21:00:00");
		Experts.setDuration(90);
		Experts.setMemberCount(0);
		rodoClasses.add(Experts);

		RodoClass Children = new RodoClass();
		Children.setId(idCount++);
		Children.setClassName("Children");
		Children.setDay("Monday");
		Children.setTutorName("Panagiotis Spirou");
		Children.setTime("17:00:00");
		Children.setDuration(60);
		Children.setMemberCount(0);
		rodoClasses.add(Children);

		return rodoClasses;
	}

	public RodoClass getRodoClassbyName(String className){

		RodoClass selectedClass = new RodoClass();
		List<RodoClass> rodoClasses = getAllRodoClasses();
		final Iterator<RodoClass> rClass = rodoClasses.iterator();
		while (rClass.hasNext()) {
			final RodoClass rC = rClass.next();
			if(rC.getClassName().equals(className)){
				selectedClass = rC;
				break;
			}
		}

		return selectedClass;
	}

	public void setGlobalLocale (String locale){
		if(locale != null)
			GlobalVariables.setLocale(locale);
	}
}
