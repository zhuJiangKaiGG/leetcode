package com.test.demo.dao;

import com.test.demo.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {

    void changePassword() throws SQLException;

    List<Client> findAllClient() throws SQLException;
}
