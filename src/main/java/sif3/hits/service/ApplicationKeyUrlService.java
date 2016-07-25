package sif3.hits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sif3.hits.domain.shared.dao.ApplicationKeyUrlDAO;
import sif3.hits.domain.shared.model.ApplicationKeyUrl;

@Service
public class ApplicationKeyUrlService {

  @Autowired
  private ApplicationKeyUrlDAO applicationKeyUrlDAO;

  @Transactional(readOnly = true, value = "sharedTransactionManager")
  public ApplicationKeyUrl getApplicationKeyUrl(String applicationKey) {
    ApplicationKeyUrl result = applicationKeyUrlDAO.findOneWithApplicationKey(applicationKey);
    if (result == null) {
      result = applicationKeyUrlDAO.findDefault();
    }
    return result;
  }
}
