package ci.ebelemgnegre.patientservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ci.ebelemgnegre.patientservice.dto.PatientRequestDTO;
import ci.ebelemgnegre.patientservice.dto.PatientResponseDTO;
import ci.ebelemgnegre.patientservice.exception.EmailAlreadyExistsException;
import ci.ebelemgnegre.patientservice.exception.PatientNotFoundException;
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
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email " + "already exists" + patientRequestDTO.getEmail());
        }

        Patient savedPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDto(savedPatient);
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient existingPatient = patientRepository.findById(id)
            .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + id));

        if (!existingPatient.getEmail().equals(patientRequestDTO.getEmail()) && 
            patientRepository.existsByEmailAndId(patientRequestDTO.getEmail(), id)) {
            throw new EmailAlreadyExistsException("A patient with this email already exists: " + patientRequestDTO.getEmail());
        }

        existingPatient.setName(patientRequestDTO.getName());
        existingPatient.setEmail(patientRequestDTO.getEmail());
        existingPatient.setAddress(patientRequestDTO.getAddress());
        existingPatient.setDateOfBirth(patientRequestDTO.getDateOfBirth());
        existingPatient.setRegisteredDate(patientRequestDTO.getRegisteredDate());

        Patient updatedPatient = patientRepository.save(existingPatient);

        return PatientMapper.toDto(updatedPatient);
    }

    public void deletePatient(UUID id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient not found with id: " + id);
        }
        
        patientRepository.deleteById(id);
    }
}
