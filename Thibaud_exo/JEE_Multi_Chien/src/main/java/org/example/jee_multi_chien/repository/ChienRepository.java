package org.example.jee_multi_chien.repository;

import org.example.jee_multi_chien.entity.Chien;

public class ChienRepository extends BaseRepository<Chien> {
    public ChienRepository() {
        super(Chien.class);
    }
}
