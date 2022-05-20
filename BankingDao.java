package com.khinezaw;

import java.sql.SQLException;

public interface BankingDao {
    void addBanking(Banking banking) throws SQLException;

    void applyBanking(Banking banking) throws SQLException;

    Banking viewBanking (int id) throws SQLException;
    void depositBanking(int balance) throws SQLException;

    void withdrawBanking(int balance) throws SQLException;

    void transferBanking(int balance) throws SQLException;

    void acceptBanking(int balance) throws SQLException;

    void acceptorrejectBanking(Banking banking) throws SQLException;

    void acceptmoneyBanking(int balance) throws SQLException;

    Banking viewtransactionBanking(int id) throws SQLException;

}

