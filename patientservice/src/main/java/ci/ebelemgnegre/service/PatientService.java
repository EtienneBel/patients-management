package ci.ebelemgnegre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ci.ebelemgnegre.dto.PatientRequestDTO;
import ci.ebelemgnegre.dto.PatientResponseDTO;
import ci.ebelemgnegre.mapper.PatientMapper;
import ci.ebelemgnegre.model.Patient;
import ci.ebelemgnegre.repository.PatientRepository;

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
