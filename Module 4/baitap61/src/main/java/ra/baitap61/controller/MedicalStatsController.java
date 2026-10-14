
package ra.baitap61.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.baitap61.model.dto.request.DoctorStatisticsDTO;
import ra.baitap61.model.dto.request.PatientStatisticsDTO;
import ra.baitap61.service.MedicalService;
import ra.baitap61.model.entity.MedicalRecord;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class MedicalStatsController {

    @Autowired
    private MedicalService medicalService;

    @GetMapping("/latest-patients")
    public List<MedicalRecord> getLatestPatients() {
        return medicalService.getLatestPatients();
    }

    @GetMapping("/top-doctors")
    public List<DoctorStatisticsDTO> getTopDoctors() {
        return medicalService.getTopDoctors();
    }

    @GetMapping("/frequent-patients")
    public List<PatientStatisticsDTO> getFrequentPatients() {
        return medicalService.getFrequentPatients();
    }
}
