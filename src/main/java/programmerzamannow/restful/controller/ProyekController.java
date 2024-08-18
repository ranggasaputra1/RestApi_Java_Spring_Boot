package programmerzamannow.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import programmerzamannow.restful.model.Proyek;
import programmerzamannow.restful.service.ProyekService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public ResponseEntity<Proyek> createProyek(@RequestBody Proyek proyek) {
        proyek.setCreatedAt(LocalDateTime.now());
        Proyek savedProyek = proyekService.saveProyek(proyek);
        return ResponseEntity.ok(savedProyek);
    }

    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        List<Proyek> proyekList = proyekService.getAllProyek();

        // Initialize the locations for each project
        for (Proyek proyek : proyekList) {
            proyek.getProyekLokasiList().forEach(proyekLokasi -> proyekLokasi.getLokasi());
        }

        return ResponseEntity.ok(proyekList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyek) {
        return proyekService.getProyekById(id).map(existingProyek -> {
            existingProyek.setNamaProyek(proyek.getNamaProyek());
            existingProyek.setClient(proyek.getClient());
            existingProyek.setTglMulai(proyek.getTglMulai());
            existingProyek.setTglSelesai(proyek.getTglSelesai());
            existingProyek.setPimpinanProyek(proyek.getPimpinanProyek());
            existingProyek.setKeterangan(proyek.getKeterangan());
            Proyek savedProyek = proyekService.saveProyek(existingProyek);
            return ResponseEntity.ok(savedProyek);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProyek(@PathVariable Long id) {
        return proyekService.getProyekById(id).map(proyek -> {
            proyekService.deleteProyek(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}