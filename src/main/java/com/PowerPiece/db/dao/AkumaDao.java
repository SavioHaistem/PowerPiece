package com.PowerPiece.db.dao;

import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.enums.AkumasType;

import java.util.List;

public interface AkumaDao {
    void add(AkumaNoMi akumaNoMi);
    void remove(AkumaNoMi akumaNoMi);
    AkumaNoMi findById(Integer id);
    List<AkumaNoMi> findAll();
    List<AkumaNoMi> findByType(AkumasType type);
}
