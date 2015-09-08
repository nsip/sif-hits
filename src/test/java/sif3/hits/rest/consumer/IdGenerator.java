package sif3.hits.rest.consumer;

import sif3.hits.utils.RefIdGenerator;

public class IdGenerator {
  public static void main(String[] args) {
    String refIds = "";
    for (int i = 0; i < 7; i++) {
      String refId = RefIdGenerator.getRefId();
      if (i < 5) {
        System.out.println("public static final String REF_ID_" + (i + 1) + " = \"" + refId + "\";");
      } else {
        System.out.println("private static final String REF_ID_" + (i - 4) + " = \"" + refId + "\";");
      }
      refIds += refId + "\n";
    }
    System.out.println("\n\n" + refIds);
  }
}
