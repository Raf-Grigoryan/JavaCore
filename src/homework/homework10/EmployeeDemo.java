package homework.homework10;


import java.text.ParseException;
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
                case SEARCH_BY_SALARY -> searchBySalary();
                case UPDATE_BY_ID -> updateEmployeeById();
                case DELETE_BY_ID -> deleteById();
                case EMPLOYEES_WITH_SALARY_ABOVE -> searchEmployeeByAboveSalary();
                case Employee_WITH_MAX_SALARY -> searchEmployeeWithMaxSalary();
                case EMPLOYEES_COUNT_WITH_COMPANY -> seeEmployeeCountByCompany();
                case CLEAR_LIST -> employeeStorage.clearAllEmployees();
                default -> System.out.println("Invalid command. Please try again.");
            }
        }
    }


    private static void addEmployee() {
        System.out.println("Please input employee id");
        String employeeID = scanner.nextLine();
        if (employeeStorage.searchEmployeeById(employeeID) == null) {
            System.out.println("Please input employee name");
            String name = scanner.nextLine();
            System.out.println("Please input employee surname");
            String surname = scanner.nextLine();
            System.out.println("Please input employee company");
            String company = scanner.nextLine();
            System.out.println("Please input employee position");
            String position = scanner.nextLine();
            System.out.println("Please input employee salary");
            double salary = Double.parseDouble(scanner.nextLine());
            employeeStorage.addEmployee(new Employee(name, surname, employeeID, company, position, salary));
        } else {
            System.out.println("Employee id already exists");
        }

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

    private static void searchBySalary() {
        try {
            System.out.println("Please input min range salary");
            double minSalary = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input max range salary");
            double maxSalary = Double.parseDouble(scanner.nextLine());
            employeeStorage.searchEmployeeBySalary(minSalary, maxSalary);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number");
        }
    }

    private static void updateEmployeeById() {
        System.out.println("Please input employee ID");
        String id = scanner.nextLine();
        if (id != null && !id.isEmpty()) {
            Employee employee = employeeStorage.searchEmployeeById(id);
            System.out.println("Please input employee new name or skip by pressing enter");
            String name = scanner.nextLine();
            System.out.println("Please input employee new surname or skip by pressing enter");
            String surname = scanner.nextLine();
            System.out.println("Please input employee new company or skip by pressing enter");
            String company = scanner.nextLine();
            System.out.println("Please input employee new position or skip by pressing enter");
            String position = scanner.nextLine();
            System.out.println("Please input employee new salary or skip by pressing enter");
            String salary = scanner.nextLine();

            if (name != null && !name.isEmpty()) {
                employee.setName(name);
            }
            if (surname != null && !surname.isEmpty()) {
                employee.setSurname(surname);
            }
            if (position != null && !position.isEmpty()) {
                employee.setPosition(position);
            }
            if (company != null && !company.isEmpty()) {
                employee.setCompany(company);
            }
            if (salary != null && !salary.isEmpty()) {
                try {
                    double newSalary = Double.parseDouble(salary);
                    employee.setSalary(newSalary);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number");
                }
            }
        } else {
            System.out.println("Employee does not exist!");
        }
    }

    private static void deleteById() {
        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        if (employeeId != null && !employeeId.isEmpty()) {
            if (employeeStorage.searchEmployeeById(employeeId) != null) {
                employeeStorage.deleteById(employeeId);
            } else {
                System.out.println("Employee does not exist!");
            }
        }
    }

    private static void searchEmployeeByAboveSalary() {
        System.out.println("Please input salary range");
        String salary = scanner.nextLine();
        if (salary != null && !salary.isEmpty()) {
            try {
                double range = Double.parseDouble(salary);
                if (range > 0) {
                    employeeStorage.printEmployeesWithSalaryAbove(range);
                } else {
                    System.out.println("Invalid input. Please enter a valid number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        }
    }

    private static void searchEmployeeWithMaxSalary() {
        Employee employee = employeeStorage.findEmployeeWithMaxSalary();
        if (employee != null) {
            System.out.println(employee);
        }
    }

    private static void seeEmployeeCountByCompany() {
        System.out.println("Please input company name");
        String company = scanner.nextLine();
        if (company != null && !company.isEmpty()) {
            employeeStorage.countEmployeesByCompany(company);
        }
    }

}
