package homework.homework10;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size = -1;

    public void addEmployee(Employee employee) {
        if (size + 1 == employees.length) {
            extend();
        }
        employees[++size] = employee;
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, size);
        employees = tmp;
    }

    public void printAllEmployees() {
        for (int i = 0; i <= size; i++) {
            System.out.println(employees[i]);
        }
    }

    public Employee searchEmployeeById(String id) {
        for (int i = 0; i <= size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                return employees[i];
            }
        }

        return null;
    }

    public void searchEmployeeByCompanyName(String companyName) {
        for (int i = 0; i <= size; i++) {
            if (employees[i].getCompany().equals(companyName)) {
                System.out.println(employees[i]);
            }
        }
    }

    public void searchEmployeeBySalary(double minSalary, double maxSalary) {
        if (minSalary < maxSalary) {
            for (int i = 0; i <= size; i++) {
                if (employees[i].getSalary() >= minSalary && employees[i].getSalary() <= maxSalary) {
                    System.out.println(employees[i]);
                }
            }
        } else {
            System.out.println("The range does not match");
        }
    }

    public void deleteById(String id) {
        for (int i = 0; i <= size; i++) {
            if (employees[i].getEmployeeId().equals(id)) {
                for (int j = i; j < size; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size] = null;
                size--;
                System.out.println("Employee with ID " + id + " has been deleted.");
                break;
            }
        }
    }
}
