package com.PowerPiece.application;
import com.PowerPiece.db.dao.*;
import com.PowerPiece.services.CacheService;

public class GameInterface {
    public static void main(String[] args) {
        System.out.println(CacheService.getAkumanomis().get(10));
    }
}
