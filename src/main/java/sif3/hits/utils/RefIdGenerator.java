package sif3.hits.utils;

import sif3.common.utils.UUIDGenerator;

public class RefIdGenerator {

  private RefIdGenerator() {
    // Static
  }

  public static String getRefId() {
    return UUIDGenerator.getSIF2GUIDUpperCase();
  }
}
