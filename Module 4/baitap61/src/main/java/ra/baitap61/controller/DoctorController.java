package ra.baitap61.controller;

import jakarta.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.baitap61.model.dto.request.DoctorCreateDTO;
import ra.baitap61.model.entity.Doctor;
import ra.baitap61.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(
            @RequestBody DoctorCreateDTO doctorCreateDTO
            ) {
        return doctorService.addDoctor(doctorCreateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> deleteDoctor(
            @PathVariable Long id
    ) {
        return doctorService.deleteDoctor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorCreateDTO doctorCreateDTO
    ) {
        return doctorService.updateDoctor(id, doctorCreateDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllDoctors(){
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }
}
