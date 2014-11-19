package sif3.hits.rest.dto;

public class KeyValuePair {
  private String key;
  private String value;

  public KeyValuePair(String key, String value) {
    this();
    this.key = key;
    this.value = value;
  }

  private KeyValuePair() {
    // Don't allow.
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
