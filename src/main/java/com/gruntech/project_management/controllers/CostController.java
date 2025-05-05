/* package com.gruntech.project_management.controllers;

import com.gruntech.project_management.models.Cost;
import com.gruntech.project_management.services.CostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/costs")
@CrossOrigin(origins = "*") // Frontend'den gelen isteklere izin verir
public class CostController {

    private final CostService costService;

    // Constructor-based dependency injection
    public CostController(CostService costService) {
        this.costService = costService;
    }

    // Tüm maliyetleri getirir
    @GetMapping
    public ResponseEntity<List<Cost>> getAllCosts() {
        return ResponseEntity.ok(costService.getAllCosts());
    }

    // ID'ye göre tek bir maliyeti getirir
    @GetMapping("/{id}")
    public ResponseEntity<Cost> getCostById(@PathVariable Long id) {
        return costService.getCostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Belirli bir projeye ait maliyetleri getirir
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Cost>> getCostsByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(costService.getCostsByProjectId(projectId));
    }

    // Yeni bir maliyet kaydı oluşturur
    @PostMapping
    public ResponseEntity<Cost> createCost(@RequestBody Cost cost) {
        return ResponseEntity.ok(costService.createCost(cost));
    }

    // Var olan bir maliyet kaydını günceller
    @PutMapping("/{id}")
    public ResponseEntity<Cost> updateCost(@PathVariable Long id, @RequestBody Cost cost) {
        return ResponseEntity.ok(costService.updateCost(id, cost));
    }

    // ID'ye göre bir maliyet kaydını siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCost(@PathVariable Long id) {
        costService.deleteCost(id);
        return ResponseEntity.noContent().build();
    }
}
*/