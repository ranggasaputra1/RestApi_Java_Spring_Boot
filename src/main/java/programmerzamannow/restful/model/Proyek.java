package programmerzamannow.restful.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Proyek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaProyek;
    private String client;
    private LocalDateTime tglMulai;
    private LocalDateTime tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "proyek", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ProyekLokasi> proyekLokasiList;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(LocalDateTime tglMulai) {
        this.tglMulai = tglMulai;
    }

    public LocalDateTime getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(LocalDateTime tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ProyekLokasi> getProyekLokasiList() {
        return proyekLokasiList;
    }

    public void setProyekLokasiList(List<ProyekLokasi> proyekLokasiList) {
        this.proyekLokasiList = proyekLokasiList;
    }
}
