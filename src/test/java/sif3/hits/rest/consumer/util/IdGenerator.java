package sif3.hits.rest.consumer.util;

import sif3.hits.utils.RefIdGenerator;

public class IdGenerator {
    public static void main(String[] args) {
        String refIds = "";
        for (int i = 0; i < 7; i++) {
            String refId = RefIdGenerator.getRefId();
            if (i == 0)
                System.out.print("    { ");
            else
                System.out.print("      ");
            System.out.print("\"" + refId + "\"");
            if (i < 6)
                System.out.print(", \n");
            else
                System.out.print(" }; \n");
            refIds += refId + "\n";
        }
        System.out.println("\n\n" + refIds + "\n\n");

        String[] refIdRA = refIds.split("\n");
        System.out.println("    public static String REF_ID_1 = \"" + refIdRA[0] + "\";");
        System.out.println("    public static String REF_ID_2 = \"" + refIdRA[1] + "\";");
        System.out.println("    public static String REF_ID_3 = \"" + refIdRA[2] + "\";");
        System.out.println("    public static String REF_ID_4 = \"" + refIdRA[3] + "\";");
        System.out.println("    public static String REF_ID_5 = \"" + refIdRA[4] + "\";");
        System.out.println("}\n");
        System.out.println("private final String REF_ID_1 = \"" + refIdRA[5] + "\";");
        System.out.println("private final String REF_ID_2 = \"" + refIdRA[6] + "\";");
    }
}