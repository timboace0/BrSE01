package ra.baitap61.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ra.baitap61.model.dto.request.DoctorStatisticsDTO;
import ra.baitap61.model.dto.request.MedicalRecordRequest;
import ra.baitap61.model.dto.request.PatientStatisticsDTO;
import ra.baitap61.model.entity.Doctor;
import ra.baitap61.model.entity.MedicalRecord;
import ra.baitap61.model.entity.Patient;
import ra.baitap61.repository.DoctorRepository;
import ra.baitap61.repository.MedicalRepository;
import ra.baitap61.repository.PatientRepository;

import java.util.List;

@Service
public class MedicalService {
    @Autowired
    private MedicalRepository medicalRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public ResponseEntity<?> createMedicalRecord(MedicalRecordRequest medicalRecordRequest){

        Patient patient = patientRepository.findById(medicalRecordRequest.getPatientId()).orElse(null);

        if(patient == null){
            return ResponseEntity.notFound().build();
        }

        Doctor doctor = doctorRepository.findById(medicalRecordRequest.getDoctorId()).orElse(null);

        if(doctor == null){
            return ResponseEntity.notFound().build();
        }

        boolean exists = medicalRepository.existsByPatientIdAndStatus(medicalRecordRequest.getPatientId(), "PROCESSING");
        if (exists) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Bệnh nhân này hiện đang có hồ sơ điều trị chưa hoàn thành");
        }

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setDiagnosis(medicalRecordRequest.getDiagnosis());
        return new ResponseEntity<>(medicalRepository.save(medicalRecord), HttpStatus.CREATED);

    }

    public List<MedicalRecord> getLatestPatients() {
        return medicalRepository
                .findTop10ByStatusOrderByCreatedAtDesc("PROCESSING");
    }

    public List<DoctorStatisticsDTO> getTopDoctors() {
        return medicalRepository.findTop10Doctors();
    }

    public List<PatientStatisticsDTO> getFrequentPatients() {
        return medicalRepository.findTop10PatientsByRecordCount();
    }
}
