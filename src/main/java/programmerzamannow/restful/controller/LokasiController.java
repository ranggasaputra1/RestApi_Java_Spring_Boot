package programmerzamannow.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programmerzamannow.restful.model.Lokasi;
import programmerzamannow.restful.service.LokasiService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public ResponseEntity<Lokasi> createLokasi(@RequestBody Lokasi lokasi) {
        Lokasi savedLokasi = lokasiService.saveLokasi(lokasi);
        return ResponseEntity.ok(savedLokasi);
    }

    @GetMapping
    public ResponseEntity<List<Lokasi>> getAllLokasi() {
        List<Lokasi> lokasiList = lokasiService.getAllLokasi();
        return ResponseEntity.ok(lokasiList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasi) {
        Optional<Lokasi> existingLokasi = lokasiService.getLokasiById(id);
        if (existingLokasi.isPresent()) {
            lokasi.setId(id);  // Ensure the ID is set to update the correct record
            Lokasi updatedLokasi = lokasiService.saveLokasi(lokasi);
            return ResponseEntity.ok(updatedLokasi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Long id) {
        Optional<Lokasi> existingLokasi = lokasiService.getLokasiById(id);
        if (existingLokasi.isPresent()) {
            lokasiService.deleteLokasi(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable Long id) {
        Optional<Lokasi> lokasi = lokasiService.getLokasiById(id);
        if (lokasi.isPresent()) {
            return ResponseEntity.ok(lokasi.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
