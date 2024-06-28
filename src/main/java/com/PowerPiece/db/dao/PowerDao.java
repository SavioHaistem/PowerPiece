package com.PowerPiece.db.dao;

import com.PowerPiece.entities.models.Power;

import java.util.Map;

public interface PowerDao {
    void add(Power power);
    void removeById(Integer power);
    Power findById(int id);
    Map<Integer, Power> findAll();
}
