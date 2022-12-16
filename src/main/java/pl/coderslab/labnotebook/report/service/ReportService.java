package pl.coderslab.labnotebook.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.report.entity.Report;
import pl.coderslab.labnotebook.report.repository.ReportRepository;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public Optional<Report> findById(long id) {
        return reportRepository.findById(id);
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public void save(Report report) {
        reportRepository.save(report);
    }

    public void delete(long id) {
        reportRepository.deleteById(id);
    }
    public Report findReportByExperimentId(long experimentId) {
        return reportRepository.findReportByExperimentId(experimentId);
    }
}
