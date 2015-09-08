package sif3.hits.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sif.dd.au30.model.JournalCollectionType;
import sif.dd.au30.model.JournalType;
import sif3.hits.domain.model.Journal;
import sif3.hits.service.JournalService;

public class JournalProvider extends
    HitsBaseProvider<JournalType, JournalCollectionType, Journal, JournalService> {

  protected static final Logger L = LoggerFactory.getLogger(JournalProvider.class);

  /**
   * @param providerID
   *          The ID of the provider.
   * @param serviceProperties
   *          values of provider property file.
   */
  public JournalProvider() {
    super(JournalType.class, "Journal", JournalCollectionType.class, "Journals",
        JournalService.class);
  }
}
