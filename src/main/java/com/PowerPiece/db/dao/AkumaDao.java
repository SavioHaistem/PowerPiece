package com.PowerPiece.db.dao;

import com.PowerPiece.entities.akumanomis.AkumaNoMi;
import com.PowerPiece.enums.AkumasType;

import java.util.List;
import java.util.Map;

public interface AkumaDao {
    void add(AkumaNoMi akumaNoMi);
    void remove(AkumaNoMi akumaNoMi);
    AkumaNoMi findById(Integer id);
    Map<Integer, AkumaNoMi> findAll();
    List<AkumaNoMi> findByType(AkumasType type);
}
