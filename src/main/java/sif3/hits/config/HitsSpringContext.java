package sif3.hits.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class HitsSpringContext implements ApplicationContextAware {

  private static ApplicationContext applicationContextInstance;

  public void setApplicationContext(ApplicationContext applicationContext) {
    applicationContextInstance = applicationContext;
  }

  public static <S> S getBean(Class<S> clazz) {
    return applicationContextInstance.getBean(clazz);
  }

  public static <S> S getBean(String name, Class<S> clazz) {
    return applicationContextInstance.getBean(name, clazz);
  }
}
