package db.dao;

import entities.akumanomis.AkumaNoMi;
import enums.AkumasType;

import java.util.List;

public interface AkumaDao {
    void add(AkumaNoMi akumaNoMi);
    void remove(AkumaNoMi akumaNoMi);
    AkumaNoMi findById(Integer id);
    List<AkumaNoMi> findAll();
    List<AkumaNoMi> findByType(AkumasType type);
}
