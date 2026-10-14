package ra.baitap61.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ra.baitap61.model.dto.request.DoctorStatisticsDTO;
import ra.baitap61.model.dto.request.PatientStatisticsDTO;
import ra.baitap61.model.entity.MedicalRecord;

import java.util.List;

public interface MedicalRepository extends JpaRepository<MedicalRecord,Long> {

    boolean existsByPatientIdAndStatus(Long patientId, String status);

    List<MedicalRecord> findTop10ByStatusOrderByCreatedAtDesc(String status);

    @Query(value = """
    SELECT d.id ,
           d.full_name,
           COUNT(m.id)
    FROM medical_record m
    JOIN doctor d ON m.doctor_id = d.id
    GROUP BY d.id, d.full_name
    ORDER BY COUNT(m.id) DESC
    LIMIT 10
    """, nativeQuery = true)
    List<DoctorStatisticsDTO> findTop10Doctors();


    @Query(value = """
    SELECT p.id AS patientId,
           p.full_name AS patientName,
           COUNT(m.id) AS totalRecords
    FROM medical_record m
    JOIN patient p ON m.patient_id = p.id
    GROUP BY p.id, p.full_name
    ORDER BY COUNT(m.id) DESC
    LIMIT 10
    """, nativeQuery = true)
    List<PatientStatisticsDTO> findTop10PatientsByRecordCount();
}
