package com.syllogos.service;

import com.syllogos.model.RodoClass;
import com.syllogos.model.RodoClassView;

import java.util.List;

public interface RodoClassService {

	RodoClass saveRodoClass(RodoClass rodoClass);

	RodoClass getClassByName(String className);

	RodoClassView getClassViewByName(String className);

	List<RodoClass> getAllRodoClasses();
}
