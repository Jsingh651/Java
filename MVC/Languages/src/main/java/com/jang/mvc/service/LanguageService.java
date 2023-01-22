package com.jang.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jang.mvc.models.LanguageModel;
import com.jang.mvc.repository.LanguageRepository;

@Service
public class LanguageService {

@Autowired
private LanguageRepository langrepo;

public List<LanguageModel> allLanguages(){
	return langrepo.findAll();
}

public LanguageModel createLanguage(LanguageModel language) {
	return langrepo.save(language);
} 
public LanguageModel updateLanguage(LanguageModel language) {
	return langrepo.save(language);
}

public void delete(Long id) {
	langrepo.deleteById(id);
}

public LanguageModel findLanguage(Long id) {
	Optional<LanguageModel> optionalLanguage = langrepo.findById(id);
	
	if (optionalLanguage.isPresent()) {
		return optionalLanguage.get();
	}
	
	else {
		return null;
		 }
	}
}
