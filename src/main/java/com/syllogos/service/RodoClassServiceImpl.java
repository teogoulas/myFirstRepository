package com.syllogos.service;

import com.syllogos.model.RodoClassView;
import com.syllogos.repository.RodoClassRepository;
import com.syllogos.model.RodoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("rodoClassService")
public class RodoClassServiceImpl implements RodoClassService {

	@Autowired
	private RodoClassRepository rodoClassRepository;

	@Override
	@Transactional
	public RodoClass saveRodoClass(RodoClass rodoClass) {
		rodoClass.setMemberCount(0);
		return rodoClassRepository.save(rodoClass);
	}

	@Override
	public RodoClass getClassByName(String className) {
		return rodoClassRepository.load(className);
	}

	@Override
	@Transactional
	public RodoClassView getClassViewByName(String className) {
		return rodoClassRepository.loadView(className);
	}

	@Override
	@Transactional
	public List<RodoClass> getAllRodoClasses() {
		return rodoClassRepository.loadAll();
	}

}
