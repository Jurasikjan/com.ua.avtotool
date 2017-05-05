package com.ua.avtotool;

import com.ua.avtotool.Connect.Moddel.oc_yandex_category;
import com.ua.avtotool.Connect.Repka.RepMashin;
import com.ua.avtotool.Connect.datasource.DataSource;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Юра on 22.04.2017.
 */
public class AppRabotaSzaprosamyKmysql {
    public static void main(String[] args) {
        RepMashin.startData();

        oc_yandex_category table =new oc_yandex_category();

        RepMashin.addObject(table);
       List<oc_yandex_category> listTable=table.getList("select * from oc_yandex_category");
        table= (oc_yandex_category) table.getPoID(1);


        System.out.println(Arrays.toString(listTable.toArray()));
    }
}
