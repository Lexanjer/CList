package ru.example.checklist ;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class DataBase implements Serializable {

    private static final String TAG = "myLogs";


    private final String[] options = {
            "bat switch", "parking bbreak",
            "navigation light", "fuel pump",
            "MMCp", "Windows hheat", "Strobe",
            "yaw dumper", "autopilot on", "A/T Set"
    };

    private final String[] value = {"Set", "Checkt", "On", "Off"};

    private static ArrayList<CheckListFull> dataBase;



    public DataBase(Context context) {


        dataBase = JSONHelper.importFromJSONassets(context);
        if (dataBase != null) {
            Toast.makeText(context, "Данные восстановлены", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Create New Base ", Toast.LENGTH_SHORT).show();
            createBase();

        }
        Log.d(TAG, "---" + dataBase);

    }



    int getCount() {
        return dataBase.size();
    }

    public static ArrayList<CheckItem> getCheckList(int position) {

        CheckListFull clf = dataBase.get(position);
        // checkList = clf.getCheckList();
        return clf.getCheckList();
    }

    static String getCheckName(int position) {
        CheckListFull clf = dataBase.get(position);
        return clf.getNameCheckList();
    }


    @Override
    public String toString() {

        return dataBase.toString();


//        return "DataBase{" +
//                "options=" + Arrays.toString(options) +
//                ", value=" + Arrays.toString(value) +
//                '}';
    }


    private ArrayList<CheckListFull> createBase() {
        Random rnd = new Random();
        dataBase = new ArrayList<>();

        for (int j = 0; j < 5; j++) {
            ArrayList<CheckItem> checkList = new ArrayList<>();

            checkList.add(new CheckItem("vvsem", "privet"));
            //int k = rnd.nextInt(10);
            for (int i = rnd.nextInt(15); i < 15; i++) {
                checkList.add(new CheckItem(options[rnd.nextInt(10)],
                        value[rnd.nextInt(4)]));

            }
            String nam = "CheckLlst" + (j + 1);
            CheckListFull clf = new CheckListFull(nam, checkList);
            dataBase.add(clf);
        }
//        Log.d(TAG, "---" + dataBase);
//        System.out.println(dataBase);
        return dataBase;
    }



}

