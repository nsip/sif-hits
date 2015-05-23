package sif3.hits.rest.consumer;

import sif3.hits.utils.RefIdGenerator;

public class IdGenerator {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      System.out.println(RefIdGenerator.getRefId());
    }
  }
}
