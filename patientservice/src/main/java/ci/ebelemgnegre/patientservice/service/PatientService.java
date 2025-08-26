package ci.ebelemgnegre.patientservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ci.ebelemgnegre.patientservice.dto.PatientRequestDTO;
import ci.ebelemgnegre.patientservice.dto.PatientResponseDTO;
import ci.ebelemgnegre.patientservice.mapper.PatientMapper;
import ci.ebelemgnegre.patientservice.model.Patient;
import ci.ebelemgnegre.patientservice.repository.PatientRepository;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients (){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(PatientMapper::toDto).toList();

        return patientResponseDTOs;
    
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient savedPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDto(savedPatient);
    }
}
