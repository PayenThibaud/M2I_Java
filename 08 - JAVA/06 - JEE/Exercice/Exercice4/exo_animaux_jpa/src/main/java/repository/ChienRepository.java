package repository;

import entity.Chien;

public class ChienRepository extends BaseRepository<Chien> {
    public ChienRepository() {
        super(Chien.class);
    }
}
