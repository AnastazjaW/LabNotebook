package pl.coderslab.labnotebook.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.labnotebook.report.entity.Report;
import pl.coderslab.labnotebook.report.repository.ReportRepository;

import java.util.List;
import java.util.Optional;

public class ReportService {
    ReportRepository reportRepository;
    @Autowired
    public void ReportRepository(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    public Optional<Report> findById(long id) {
        return reportRepository.findById(id);
    }

    private List<Report> findAll() {
        return reportRepository.findAll();
    }

    private void save(Report report) {
        reportRepository.save(report);
    }

    private void delete(long id) {
        reportRepository.deleteById(id);
    }
    private Report findReportByExperimentId(long experimentId) {
        return reportRepository.findReportByExperimentId(experimentId);
    }
}
