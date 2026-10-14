package ra.baitap61.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.baitap61.model.dto.request.DoctorCreateDTO;
import ra.baitap61.model.dto.request.PatientCreateDTO;
import ra.baitap61.model.dto.response.PaginationResponse;
import ra.baitap61.model.entity.Doctor;
import ra.baitap61.model.entity.Patient;
import ra.baitap61.service.DoctorService;
import ra.baitap61.service.PatientService;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(
            @RequestBody PatientCreateDTO patientCreateDTO
    ) {
        return patientService.addPatient(patientCreateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(
            @PathVariable Long id
    ) {
        return patientService.deletePatient(id);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPatientAndPagination(
            @RequestParam(value = "patientName") String patientName,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        return new ResponseEntity<>(patientService.searchPatients(patientName, page, size), HttpStatus.OK);
    }
}
