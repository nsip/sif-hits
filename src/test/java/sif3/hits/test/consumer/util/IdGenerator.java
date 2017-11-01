package sif3.hits.test.consumer.util;

import sif3.hits.utils.RefIdGenerator;

public class IdGenerator {
  public static void main(String[] args) {
    String refIds = "";
    for (int i = 0; i < 7; i++) {
      String refId = RefIdGenerator.getRefId();
      if (i == 0) System.out.print("    { ");
      else System.out.print("      ");
      System.out.print("\"" + refId + "\"");
      if (i < 6) System.out.print(", \n");
      else System.out.print(" }; \n");
      refIds += refId + "\n";
    }
    System.out.println("\n\n" + refIds);
  }
  
  //5cfb86c0-0045-4f85-a5e1-d9b482f68c5b
  //d04f3b32-b18c-4873-8ac0-8b8a29e9ae55
}
