package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.LibraryMessageType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.LibraryPatronMessage;

@Component
public class LibraryPatronMessageConverter extends HitsConverter<LibraryMessageType, LibraryPatronMessage> {

	public LibraryPatronMessageConverter() {
		super(LibraryMessageType.class, LibraryPatronMessage.class);
	}

	@Override
	public void toSifModel(LibraryPatronMessage source, LibraryMessageType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			
			target.setSent(objectFactory.createLibraryMessageTypeSent(getCalendarValue(source.getSent())));
			target.setText(source.getText());
			target.setPriority(source.getPriority());
			target.setPriorityCodeset(source.getPriorityCodeset());
		}
	}

	@Override
	public void toHitsModel(LibraryMessageType source, LibraryPatronMessage target) {
		if (source != null && target != null) {
			target.setSent(getCalendarValue(getJAXBValue(source.getSent())));
			target.setText(source.getText());
			target.setPriority(source.getPriority());
			target.setPriorityCodeset(source.getPriorityCodeset());
		}
	}

}
