package book.chapter5;

import java.io.IOException;

public class Menu {


    public static void main(String[] args) throws IOException {
        char choice;
        do {
            System.out.println("Cпpaвкa по оператору:");
            System.out.println("1.if");
            System.out.println("2.switch");
            System.out.println("3.while");
            System.out.println("4 do-while");
            System.out.println("5 for\n");
            System.out.println("Bыбepитe нужный пункт:");
            choice = (char) System.in.read();
        } while (choice < '1' || choice > '5');
        switch (choice) {
            case '1' -> {
                System.out.println("if:");
                System.out.println("if(ycлoвиe) оператор;");
                System.out.println("else оператор;");
            }
            case '2' -> {
                System.out.println("switch");
                System.out.println("switch(выражение){");
                System.out.println("case константа:");
                System.out.println("// ... " +
                        "break;");
                System.out.println("}");
            }
            case '3' -> {
                System.out.println("while:");
                System.out.println("while(ycлoвиe) оператор;");
                System.out.println("break");
            }
            case '4' -> {
                System.out.println("do-while");
                System.out.println("do {");
                System.out.println("оператор;");
                System.out.println("while (условие);");
            }
            case '5' -> {
                System.out.println("for:");
                System.out.println("for(нициaлизaция; условие; итерация){");
                System.out.println("оператор;}");
            }
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
}
