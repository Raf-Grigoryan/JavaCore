package homework.homework10;

public interface Commands {
    String EXIT = "0";
    String ADD_EMPLOYEE = "1";
    String PRINT_EMPLOYEES = "2";
    String SEARCH_BY_ID = "3";
    String SEARCH_BY_COMPANY = "4";
    String SEARCH_BY_SALARY = "5";
    String UPDATE_BY_ID = "6";
    String DELETE_BY_ID = "7";

    static void commands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_EMPLOYEE + " for add employee");
        System.out.println("Please input " + PRINT_EMPLOYEES + " for print all employees");
        System.out.println("Please input " + SEARCH_BY_ID + " for search employee by id");
        System.out.println("Please input " + SEARCH_BY_COMPANY + " for search employee by company");
        System.out.println("Please input " + SEARCH_BY_SALARY + " for search by salary");
        System.out.println("Please input " + UPDATE_BY_ID + " for update employee by id");
        System.out.println("Please input " + DELETE_BY_ID + " for delete employee by id");
    }

}
