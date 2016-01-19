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
  
  //5cfb86c0-0045-4f85-a5e1-d9b482f68c5b
  //d04f3b32-b18c-4873-8ac0-8b8a29e9ae55
}
