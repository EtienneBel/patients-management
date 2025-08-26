package ci.ebelemgnegre.patientservice.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class PatientRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "Registered date is required")
    private LocalDate registeredDate;


    public PatientRequestDTO() {
    }

    public PatientRequestDTO(String name, String email, String address, LocalDate dateOfBirth, LocalDate registeredDate) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.registeredDate = registeredDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getRegisteredDate() {
        return this.registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public PatientRequestDTO name(String name) {
        setName(name);
        return this;
    }

    public PatientRequestDTO email(String email) {
        setEmail(email);
        return this;
    }

    public PatientRequestDTO address(String address) {
        setAddress(address);
        return this;
    }

    public PatientRequestDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public PatientRequestDTO registeredDate(LocalDate registeredDate) {
        setRegisteredDate(registeredDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PatientRequestDTO)) {
            return false;
        }
        PatientRequestDTO patientRequestDTO = (PatientRequestDTO) o;
        return Objects.equals(name, patientRequestDTO.name) && Objects.equals(email, patientRequestDTO.email) && Objects.equals(address, patientRequestDTO.address) && Objects.equals(dateOfBirth, patientRequestDTO.dateOfBirth) && Objects.equals(registeredDate, patientRequestDTO.registeredDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, address, dateOfBirth, registeredDate);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", registeredDate='" + getRegisteredDate() + "'" +
            "}";
    }
    
}
