package com.test.demo.dao.impl;

import com.test.demo.entity.Client;
import com.test.demo.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 20:32 2020-09-09
 * @Description
 **/
@Service
public class ClientDaoImpl implements ClientDao {
    @Autowired
    DataSource dataSource;
    static PreparedStatement pstmt = null;
    static Savepoint savePoint = null;
    @Override
    public void changePassword() throws SQLException {
        String s = "ssss";
        String result = "";
        result = result + s.substring(1, 2);
        Connection connection = dataSource.getConnection();
        String sql = "UPDATE client SET client.c_password='12306' WHERE c_id=7";
        pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    @Override
    public List<Client> findAllClient() throws SQLException {
        Connection connection = dataSource.getConnection();
        List<Client>list=new ArrayList<>();
//        CallableStatement cs = connection.prepareCall("{call findAllClient()}");
//        ResultSet resultSet = cs.executeQuery();
//        System.out.println("result");
//        //System.out.println(resultSet);
//        while (resultSet.next()) {
//            client.setcId(resultSet.getInt("c_id"));
//            client.setcIdCard(resultSet.getString("c_id_card"));
//            client.setcName(resultSet.getString("c_name"));
//            client.setcMail(resultSet.getString("c_mail"));
//            client.setcPassword(resultSet.getString("c_password"));
//            client.setcPhone(resultSet.getString("c_phone"));
//            System.out.println(client);
//        }
        return list;
    }
}
