package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.LibraryPatronLocalCode;

@Component
public class LibraryPatronLocalCodeConverter extends BaseLocalCodeConverter<LibraryPatronLocalCode> {

	public LibraryPatronLocalCodeConverter() {
		super(LibraryPatronLocalCode.class);
	}
	
}
