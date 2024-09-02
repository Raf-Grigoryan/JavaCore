package homework.homework10;

public interface Commands {
    String EXIT = "0";
    String ADD_EMPLOYEE = "1";
    String PRINT_EMPLOYEES = "2";
    String SEARCH_BY_ID = "3";
    String SEARCH_BY_COMPANY = "4";

    static void commands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_EMPLOYEE + " for add employee");
        System.out.println("Please input " + SEARCH_BY_ID + " for search employee by id");
        System.out.println("Please input " + SEARCH_BY_COMPANY + " for search employee by company");
    }
}
