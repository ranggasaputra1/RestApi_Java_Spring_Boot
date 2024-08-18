package programmerzamannow.restful.dto;

import programmerzamannow.restful.model.Proyek;
import programmerzamannow.restful.model.Lokasi;

import java.util.List;

public class ProyekRequest {

    private Proyek proyek;
    private List<Lokasi> lokasiList;

    // Getters and Setters

    public Proyek getProyek() {
        return proyek;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
    }

    public List<Lokasi> getLokasiList() {
        return lokasiList;
    }

    public void setLokasiList(List<Lokasi> lokasiList) {
        this.lokasiList = lokasiList;
    }
}