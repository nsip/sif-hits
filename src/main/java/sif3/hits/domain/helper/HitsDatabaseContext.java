package sif3.hits.domain.helper;

public class HitsDatabaseContext {

  private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

  public static void setDatabase(String database) {
    contextHolder.set(database);
  }

  public static String getDatabase() {
    return contextHolder.get();
  }

  public static void clearDatabase() {
    contextHolder.remove();
  }
}
