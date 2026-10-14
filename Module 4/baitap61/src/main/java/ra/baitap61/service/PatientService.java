package ra.baitap61.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.baitap61.model.dto.request.DoctorCreateDTO;
import ra.baitap61.model.dto.request.PatientCreateDTO;
import ra.baitap61.model.dto.response.PaginationResponse;
import ra.baitap61.model.entity.Doctor;
import ra.baitap61.model.entity.Patient;
import ra.baitap61.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public ResponseEntity<Patient> addPatient(PatientCreateDTO patientCreateDTO){
        Patient patient = new Patient();
        patient.setPatientCode(patientCreateDTO.getPatientCode());
        patient.setFullName(patientCreateDTO.getFullName());
        patient.setAddress(patientCreateDTO.getAddress());
        patient.setPhone(patientCreateDTO.getPhone());

        return new ResponseEntity<>(patientRepository.save(patient), HttpStatus.CREATED);
    }

    public ResponseEntity<Patient> deletePatient(Long id){
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        patientRepository.delete(patient);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public Page<Patient> findAllAndSearch(
            Pageable pageable,
            String patientName
    ) {
        return patientRepository.findAllByFullNameContaining(patientName, pageable);
    }

    public PaginationResponse searchPatients(
            String patientName,
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,"fullName"));

        Page<Patient> result =
                        findAllAndSearch(pageable,patientName);

        return PaginationResponse.builder()
                .data(result.getContent())
                .totalPage(result.getTotalPages())
                .totalElement((int) result.getTotalElements())
                .currentPage(result.getNumber())
                .build();
    }
}
