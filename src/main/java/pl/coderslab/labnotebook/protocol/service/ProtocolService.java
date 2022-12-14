package pl.coderslab.labnotebook.protocol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.protocol.entity.Protocol;
import pl.coderslab.labnotebook.protocol.repository.ProtocolRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProtocolService {
    private final ProtocolRepository protocolRepository;

    public Optional<Protocol> findById(long id) {
        return protocolRepository.findById(id);
    }

    public List<Protocol> findAll() {
        return protocolRepository.findAll();
    }

    public void save(Protocol protocol) {
        LocalDateTime date = LocalDateTime.now();
        protocol.setLastModificationDate(date);
        protocolRepository.save(protocol);
    }

    public void delete(long id) {
        protocolRepository.deleteById(id);
    }
    public List<Protocol> findProtocolsByUserIdSortedByLastModificationDate(long userId) {
        return protocolRepository.findProtocolsByUserIdSortedByLastModificationDate(userId);
    }
    public Protocol findProtocolByExperimentId(long experimentId){
        return protocolRepository.findProtocolByExperimentId(experimentId);
    }
}
