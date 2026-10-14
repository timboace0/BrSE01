package ra.baitap61.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.baitap61.model.dto.request.DoctorCreateDTO;
import ra.baitap61.model.entity.Doctor;
import ra.baitap61.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public ResponseEntity<Doctor> addDoctor(DoctorCreateDTO doctorCreateDTO){
        Doctor doctor = new Doctor();
        doctor.setDoctorCode(doctorCreateDTO.getDoctorCode());
        doctor.setFullName(doctorCreateDTO.getFullName());
        doctor.setSpecialization(doctorCreateDTO.getSpecialization());
        doctor.setExperienceYears(doctorCreateDTO.getExperienceYears());

        return new ResponseEntity<>(doctorRepository.save(doctor), HttpStatus.CREATED);
    }

    public ResponseEntity<Doctor> deleteDoctor(Long id){
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if(doctor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        doctorRepository.delete(doctor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<?> updateDoctor(Long id, DoctorCreateDTO doctorCreateDTO){
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if(doctor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        doctor.setDoctorCode(doctorCreateDTO.getDoctorCode());
        doctor.setFullName(doctorCreateDTO.getFullName());
        doctor.setSpecialization(doctorCreateDTO.getSpecialization());
        doctor.setExperienceYears(doctorCreateDTO.getExperienceYears());

        return new ResponseEntity<>(doctorRepository.save(doctor), HttpStatus.OK);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
}
