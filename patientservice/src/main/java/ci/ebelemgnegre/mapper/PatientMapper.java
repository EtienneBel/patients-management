package ci.ebelemgnegre.mapper;

import ci.ebelemgnegre.dto.PatientRequestDTO;
import ci.ebelemgnegre.dto.PatientResponseDTO;
import ci.ebelemgnegre.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDto(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setName(patient.getName());

        return patientResponseDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO) {
        Patient newPatient = new Patient();
        newPatient.setName(patientRequestDTO.getName());
        newPatient.setAddress(patientRequestDTO.getAddress());
        newPatient.setDateOfBirth(patientRequestDTO.getDateOfBirth());
        newPatient.setEmail(patientRequestDTO.getEmail());
        newPatient.setRegisteredDate(patientRequestDTO.getRegisteredDate());

        return newPatient;
    }
}
