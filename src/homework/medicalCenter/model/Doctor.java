package homework.medicalCenter.model;


import java.util.Objects;

public class Doctor extends Person {
    private String email;
    private ProfessionType professionType;

    public Doctor() {

    }

    public Doctor(String id, String name, String surname, String phoneNumber, String email, ProfessionType professionType) {
        super(id, name, surname, phoneNumber);
        this.email = email;
        this.professionType = professionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfessionType getProfessionType() {
        return professionType;
    }

    public void setProfessionType(ProfessionType professionType) {
        this.professionType = professionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(email, doctor.email) && professionType == doctor.professionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, professionType);
    }

    @Override
    public String toString() {
        return super.toString() + "Doctor{" +
                "email='" + email + '\'' +
                ", professionType=" + professionType +
                '}';
    }
}
