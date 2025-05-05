/*  package com.gruntech.project_management.services;

import com.gruntech.project_management.models.Cost;
import com.gruntech.project_management.repositories.CostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostService {

    private final CostRepository costRepository;

    public CostService(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    public List<Cost> getAllCosts() {
        return costRepository.findAll();
    }

    public Optional<Cost> getCostById(Long id) {
        return costRepository.findById(id);
    }

    public Cost createCost(Cost cost) {
        return costRepository.save(cost);
    }

    public Cost updateCost(Long id, Cost updatedCost) {
        return costRepository.findById(id)
                .map(cost -> {
                    cost.setDate(updatedCost.getDate());
                    cost.setDescription(updatedCost.getDescription());
                    cost.setAmount(updatedCost.getAmount());
                    cost.setProject(updatedCost.getProject());
                    return costRepository.save(cost);
                })
                .orElseGet(() -> {
                    updatedCost.setId(id);
                    return costRepository.save(updatedCost);
                });
    }

    public void deleteCost(Long id) {
        costRepository.deleteById(id);
    }

    public List<Cost> getCostsByProjectId(Long projectId) {
        return costRepository.findByProjectId(projectId);
    }
} */
