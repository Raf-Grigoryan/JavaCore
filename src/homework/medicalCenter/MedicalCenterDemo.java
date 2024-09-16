package homework.medicalCenter;

import homework.homework9.Commands;
import homework.medicalCenter.exception.TimeNotAllowedException;
import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.ProfessionType;
import homework.medicalCenter.storage.MedicalStorage;
import homework.medicalCenter.util.DateUtil;
import homework.medicalCenter.util.MedicalCommands;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MedicalCenterDemo implements MedicalCommands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MedicalStorage medicalStorage = new MedicalStorage();
    private static final AtomicInteger doctorIdGenerator = new AtomicInteger(100);
    private static final AtomicInteger patientIdGenerator = new AtomicInteger(100);

    public static void main(String[] args) {
        process();
    }

    private static void process() {
        boolean isRun = true;
        while (isRun) {
            Commands.commands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT -> {
                    System.out.println("BYE");
                    isRun = false;
                }
                case ADD_DCOTOR -> addDoctor();
                case SEARCH_DOCTOR_BY_PROFESSION -> searchDoctorByProfession();
                case DELETE_DOCTOR_BY_ID -> deleteDoctorById();
                case CHANGE_DOCTOR -> changeDoctor();
                case ADD_PATIENT -> addPatient();
                case PRINT_PATIENT_BY_DOCTOR -> printAllPatientByDoctor();
                case PRINT_ALL_PATIENT -> medicalStorage.printAllPatients();
                default -> System.out.println("Wrong command please try again!");
            }
        }
    }

    private static void addDoctor() {
        System.out.println("Please input doctor email");
        String email = scanner.nextLine();
        if (medicalStorage.getDoctorByEmail(email) == null) {
            System.out.println("Please input Doctor name,surname,phone,profession");
            String[] doctorStr = scanner.nextLine().split(",");
            if (doctorStr.length == 4) {
                String id = "D" + doctorIdGenerator.getAndIncrement();
                String name = doctorStr[0];
                String surname = doctorStr[1];
                String phone = doctorStr[2];
                String profession = doctorStr[3];
                medicalStorage.add(new Doctor(id, name, surname, email, phone, ProfessionType.valueOf(profession.toUpperCase())));
            } else {
                System.out.println("Invalid Doctor Information please try again!");
            }
        } else {
            System.out.println("Email is already exist!!");
        }
    }

    private static void searchDoctorByProfession() {
        System.out.println("Please input profession name");
        String profession = scanner.nextLine();
        medicalStorage.searchDoctorByProfession(profession);
    }

    private static void deleteDoctorById() {
        System.out.println("Please input doctor id");
        String doctorId = scanner.nextLine();
        if (medicalStorage.deleteDoctorById(doctorId)) {
            System.out.println("Doctor deleted");
        } else {
            System.out.println("Couldn't delete doctor");
        }

    }

    private static void changeDoctor() {
        System.out.println("Please input id for change doctor");
        String doctorId = scanner.nextLine();
        Doctor doctor = medicalStorage.getDoctorById(doctorId);
        if (doctor != null) {
            System.out.println("Please input name of the doctor or press Enter to skip");
            String name = scanner.nextLine();
            System.out.println("Please input surname of the doctor or press Enter to skip");
            String surname = scanner.nextLine();
            System.out.println("Please input email of the doctor or press Enter to skip");
            String email = scanner.nextLine();
            System.out.println("Please input phone number of the doctor or press Enter to skip");
            String phoneNumber = scanner.nextLine();
            System.out.println("Please input profession of the doctor or press Enter to skip");
            String profession = scanner.nextLine();
            if (name != null && !name.isEmpty()) {
                doctor.setName(name);
            }
            if (!name.isEmpty()) {
                doctor.setName(name);
            }
            if (!surname.isEmpty()) {
                doctor.setSurname(surname);
            }
            if (!email.isEmpty()) {
                doctor.setEmail(email);
            }
            if (!phoneNumber.isEmpty()) {
                doctor.setPhoneNumber(phoneNumber);
            }
            if (!profession.isEmpty()) {
                doctor.setProfessionType(ProfessionType.valueOf(profession.toUpperCase()));
            }
        } else {
            System.out.println("Doctor does not exist!!!");
        }

    }

    private static void addPatient() {
        if (medicalStorage.getDoctorsCount() > 0) {
            medicalStorage.printAllDoctors();
            System.out.println("Please input doctor id");
            String doctorId = scanner.nextLine();
            Doctor doctor = medicalStorage.getDoctorById(doctorId);
            if (doctor != null) {
                try {
                    System.out.println("Please input registration date 09-10-2000 10:00");
                    String dateStr = scanner.nextLine();
                    Date date = DateUtil.stringToDateByTime(dateStr);

                    if (!medicalStorage.isTimeAvailable(date, doctor)) {
                        throw new TimeNotAllowedException("The selected time is not available. Please choose another time.");
                    }

                    System.out.println("Please input patient name");
                    String name = scanner.nextLine();
                    System.out.println("Please input patient surname");
                    String surname = scanner.nextLine();
                    System.out.println("Please input phone number");
                    String phoneNumber = scanner.nextLine();
                    String patientId = "P" + patientIdGenerator.getAndIncrement();
                    medicalStorage.add(new Patient(patientId, name, surname, phoneNumber, doctor, date));

                } catch (ParseException e) {
                    System.out.println("Error: Please input date in this format 09-10-2000 10:00");
                } catch (TimeNotAllowedException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid doctor id please try again");
            }
        }
    }

    private static void printAllPatientByDoctor() {
        if (medicalStorage.getDoctorsCount() > 0) {
            medicalStorage.printAllDoctors();
            System.out.println("Please input doctor id");
            String doctorId = scanner.nextLine();
            medicalStorage.printPatientsByDoctorId(doctorId);
        }
    }

}
