package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif3.hits.domain.model.LibraryPatronName;

@Component
public class LibraryPatronNameConverter extends BaseNameOfRecordConverter<LibraryPatronName> {

	public LibraryPatronNameConverter() {
		super(LibraryPatronName.class);
	}
}
