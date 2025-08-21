package ci.ebelemgnegre.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.ebelemgnegre.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>{
    
}
