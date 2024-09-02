package homework.homework10;

import java.sql.SQLOutput;
import java.util.Scanner;

public class EmployeeDemo implements Commands {

    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {
        process();
    }

    private static void process() {
        boolean isRun = true;
        while (isRun) {
            Commands.commands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT -> isRun = false;
                case PRINT_EMPLOYEES -> employeeStorage.printAllEmployees();
                case ADD_EMPLOYEE -> addEmployee();
                case SEARCH_BY_ID -> searchByID();
                case SEARCH_BY_COMPANY -> searchByCompany();
            }
        }
    }




    private static void addEmployee() {
        System.out.println("Please input employee name");
        String name = scanner.nextLine();
        System.out.println("Please input employee surname");
        String surname = scanner.nextLine();
        System.out.println("Please input employee id");
        String employeeID = scanner.nextLine();
        System.out.println("Please input employee company");
        String company = scanner.nextLine();
        System.out.println("Please input employee position");
        String position = scanner.nextLine();
        System.out.println("Please input employee salary");
        double salary = Double.parseDouble(scanner.nextLine());
        employeeStorage.addEmployee(new Employee(name, surname, employeeID, company, position, salary));
    }

    private static void searchByID() {
        System.out.println("Please input employee id");
        String id = scanner.nextLine();
        System.out.println(employeeStorage.searchEmployeeById(id));
    }

    private static void searchByCompany() {
        System.out.println("Please input company for search employees");
        String company = scanner.nextLine();
        employeeStorage.searchEmployeeByCompanyName(company);
    }
}
