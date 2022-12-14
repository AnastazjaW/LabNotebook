package pl.coderslab.labnotebook.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.labnotebook.protocol.entity.Protocol;
import pl.coderslab.labnotebook.report.entity.Report;

import java.util.List;
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "select * from reports r where r.experiment_id = :experimentId", nativeQuery = true)
    Report findReportByExperimentId(@Param("experimentId") long experimentId);
    @Query("select r from Report r where r.user.id = :userId order by r.lastModificationDate desc")
    List<Protocol> findProtocolsByUserIdSortedByLastModificationDate(@Param("userId") long userId);
}
