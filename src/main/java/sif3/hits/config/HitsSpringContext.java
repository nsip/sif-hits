package sif3.hits.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class HitsSpringContext implements ApplicationContextAware {

  @Autowired
  private ApplicationContext applicationContext;

  private static ApplicationContext applicationContextInstance;

  public void setApplicationContext(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
    applicationContextInstance = applicationContext;
  }

  public static <S> S getBean(Class<S> clazz) {
    return applicationContextInstance.getBean(clazz);
  }
}
