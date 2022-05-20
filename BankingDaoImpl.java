package com.khinezaw;

import java.sql.*;

public class BankingDaoImpl implements BankingDao {

    Connection connection;
    private String PreparedStatement;
    private Banking banking;

    public BankingDaoImpl() {

        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addBanking(Banking banking) throws SQLException {
        String sql = "insert into banking (username, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, banking.getUsername());
        preparedStatement.setString(2, banking.getPassword());
        int count = preparedStatement.executeUpdate();
        if (preparedStatement.executeUpdate() > 0) System.out.println("Logged In SUCCESSFULLY");
        else System.out.println("Oops! Login Failed :(");
    }

    @Override
    public void applyBanking(Banking banking) throws SQLException {
        String sql = "update banking SET id = ?, name = ?, email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, banking.getId());
        preparedStatement.setString(2, banking.getName());
        preparedStatement.setString(3, banking.getEmail());
        if (preparedStatement.executeUpdate() > 0) System.out.println("Thank you for registering a new account!");
        else System.out.println("Oops! something went wrong");
    }

    @Override
    public Banking viewBanking(int id) throws SQLException {
        Banking banking = new Banking ();
        banking.setId(id);
        String sql = "select * from banking WHERE ID = " +id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()) return(new Banking(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3)));
        return banking;
    }



    @Override
    public void depositBanking(int balance) throws SQLException {
        String sql = "update banking set balance = ?";
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery(sql);
        if(resultSet!=null) {
            balance = resultSet.getInt(1);
            System.out.println("You have deposited: ");
        }else{
            System.out.println("Deposit Failed: ");
        }
    }

    @Override
    public void withdrawBanking(int balance) throws SQLException {
        String sql = "insert into banking (balance) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("You have withdraw: ");
        else
            System.out.println("Withdraw Failed: ");
    }

    @Override
    public void transferBanking(int balance) throws SQLException {
        String sql = "insert into banking (balance) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("You have withdraw: ");
        else
            System.out.println("Withdrawal Failed: ");
    }

    @Override
    public void acceptBanking(int balance) throws SQLException {
        String sql = "insert into banking (balance) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("You have accepted: ");
        else
            System.out.println("Acceptance Failed: ");
    }

    @Override
    public void acceptorrejectBanking(Banking banking) throws SQLException {
        String sql = "insert into banking (username, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, banking.getUsername());
        preparedStatement.setString(2, banking.getPassword());
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Thank you, your account is being reviewed");
        else
            System.out.println("Sorry, you can't proceed at the moment");

    }
    @Override
    public void acceptmoneyBanking(int balance) throws SQLException{
        String sql = "insert into banking (balance) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("You are accepted: ");
        else
            System.out.println("Acceptance failed: ");
    }

    @Override
    public Banking viewtransactionBanking(int id) throws SQLException {
        Banking banking = new Banking();
        banking.setId(id);
        String sql = "select * from banking WHERE ID = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) return (new Banking(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        return banking;
    }
}