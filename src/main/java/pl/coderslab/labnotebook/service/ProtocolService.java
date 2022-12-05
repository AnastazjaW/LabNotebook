package pl.coderslab.labnotebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.labnotebook.entity.Protocol;
import pl.coderslab.labnotebook.repository.ProtocolRepository;

import java.util.List;
import java.util.Optional;

public class ProtocolService {
    ProtocolRepository protocolRepository;
    @Autowired
    public void ProtocolRepository(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }
    public Optional<Protocol> findById(long id) {
        return protocolRepository.findById(id);
    }

    private List<Protocol> findAll() {
        return protocolRepository.findAll();
    }

    private void save(Protocol protocol) {
        protocolRepository.save(protocol);
    }

    private void delete(long id) {
        protocolRepository.deleteById(id);
    }
    private List<Protocol> findProtocolsByUserIdSortedByLastModificationDate(long userId) {
        return protocolRepository.findProtocolsByUserIdSortedByLastModificationDate(userId);
    }
    private Protocol findProtocolByExperimentId(long experimentId){
        return protocolRepository.findProtocolByExperimentId(experimentId);
    }
}
