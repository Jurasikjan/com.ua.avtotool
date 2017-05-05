package com.ua.avtotool.Connect.Moddel;

import com.ua.avtotool.Connect.Repka.RepMashin;
import lombok.Data;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 22.04.2017.
 */
@Data
public class oc_yandex_category extends RepMashin{

    private int yandex_category_id;
    private Reader level1;
    private Reader level2;
    private Reader level3;

    private static List<Integer> idStr=new ArrayList<>();


    @Override
    public List<oc_yandex_category> getAll(ResultSet resultSet) throws SQLException {

        List<oc_yandex_category> result = new ArrayList<>();
        while (resultSet.next()) {

            oc_yandex_category tresult=new oc_yandex_category();
            tresult.yandex_category_id = resultSet.getInt("yandex_category_id");
            idStr.add(yandex_category_id);
            tresult.level1 = resultSet.getCharacterStream("level1");
            tresult.  level1 = resultSet.getCharacterStream("level2");
            tresult. level1 = resultSet.getCharacterStream("level3");
            result.add(tresult);

        }
        return result;
    }

    @Override
    public String toString() {
        return "oc_yandex_category{" +
                "yandex_category_id=" + yandex_category_id +
                ", level1='" + level1 + '\'' +
                ", level2='" + level2 + '\'' +
                ", level3='" + level3 + '\'' +
                "}\n";
    }

    @Override
    public RepMashin getPoID(int id) {

        return null;
    }
}
