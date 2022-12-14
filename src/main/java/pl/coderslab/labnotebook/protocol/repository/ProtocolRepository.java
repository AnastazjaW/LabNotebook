package pl.coderslab.labnotebook.protocol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.labnotebook.protocol.entity.Protocol;

import java.util.List;
@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
    @Query("select p from Protocol p where p.user.id = :userId order by p.lastModificationDate desc")
    List<Protocol> findProtocolsByUserIdSortedByLastModificationDate(@Param("userId") long userId);
    @Query(value = "select * from protocols p join experiments e on p.id = e.protocol_id where e.id = :experimentId", nativeQuery = true)
    Protocol findProtocolByExperimentId(@Param("experimentId") long experimentId);

}
