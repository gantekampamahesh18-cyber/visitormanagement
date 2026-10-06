package com.visitormanagement.vrmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visitormanagement.vrmt.entity.Visitor;
import com.visitormanagement.vrmt.repository.VisitorRepository;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    // Create visitor
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    // Get all visitors
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    // Get visitor by ID
    public Optional<Visitor> getVisitorById(Long id) {
        return visitorRepository.findById(id);
    }

    // Update visitor
    public Visitor updateVisitor(Long id, Visitor visitorDetails) {

        Visitor visitor = visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        visitor.setName(visitorDetails.getName());
        visitor.setPhone(visitorDetails.getPhone());
        visitor.setEmail(visitorDetails.getEmail());
        visitor.setAddress(visitorDetails.getAddress());
        visitor.setIdProof(visitorDetails.getIdProof());
        visitor.setIdProofNumber(visitorDetails.getIdProofNumber());
        visitor.setPhoto(visitorDetails.getPhoto());

        return visitorRepository.save(visitor);
    }

    // Delete visitor
    public void deleteVisitor(Long id) {
        visitorRepository.deleteById(id);
    }
}
