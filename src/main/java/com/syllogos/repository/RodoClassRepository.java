package com.syllogos.repository;

import com.syllogos.model.RodoClass;
import com.syllogos.model.RodoClassView;

import java.util.List;

public interface RodoClassRepository {

	RodoClass save(RodoClass rodoClass);

	RodoClass load(String className);

	RodoClassView loadView(String className);

	List<RodoClass> loadAll();
}
