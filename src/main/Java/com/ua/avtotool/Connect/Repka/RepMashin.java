package com.ua.avtotool.Connect.Repka;

import com.ua.avtotool.Connect.datasource.DataSource;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 11.04.2017.
 */
@Data
public abstract class RepMashin implements Work {

    static {
        masObject = new ArrayList<>();
    }

    private static List<RepMashin> masObject;
    private static DataSource dataSource;

    public static DataSource startData() {

        return dataSource = DataSource.getInstance();
    }

    public Connection getConnect() {
        return dataSource.getConnection();
    }

    public static void addObject(RepMashin... repMashin) {
        for (RepMashin mashin : repMashin) {
            masObject.add(mashin);
        }

    }
    @Override
    public List getList(String zapros) {

        String sql = String.format(zapros);
        List result = null;
        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            result = getAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public RepMashin getPoID(int id) {

        for (RepMashin repMashin : masObject) {
            repMashin.equals(this);
        }
        return null;
    }

    public abstract List getAll(ResultSet resultSet) throws SQLException;
}
