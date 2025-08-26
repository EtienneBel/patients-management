package ci.ebelemgnegre.patientservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.ebelemgnegre.patientservice.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>{
    boolean existsByEmail(String email);
    
    boolean existsByEmailAndId(String email, UUID id);
}
