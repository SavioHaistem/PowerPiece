package com.PowerPiece.db.dao.impl;

import java.sql.Connection;

public class ChamberDaoJdbc {
    Connection connection;
    public ChamberDaoJdbc(Connection connection) {
        this.connection = connection;
    }
}
