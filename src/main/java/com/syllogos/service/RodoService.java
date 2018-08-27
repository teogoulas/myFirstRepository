package com.syllogos.service;

import com.syllogos.model.RodoClass;

import java.util.ArrayList;
import java.util.List;

public interface RodoService {

	ArrayList<RodoClass> getAllRodoClasses();

	RodoClass getRodoClassbyName(String className);

	public void setGlobalLocale(String locale);

}
