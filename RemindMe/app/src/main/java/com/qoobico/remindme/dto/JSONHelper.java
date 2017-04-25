package com.qoobico.remindme.dto;


 //compile 'com.google.code.gson:gson:2.8.0'

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.qoobico.remindme.dto.CheckListFull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSONHelper {

    private static final String FILE_NAME = "DataFile.json";
    //   static final String LOG_TAG = "myLogs";
    // Log.d(JSONHelper.LOG_TAG, "itemSelect: position = всем привет" );


    static boolean exportToJSONdata(Context context, ArrayList<CheckListFull> dataList) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setDataBase(dataList);
        String jsonString = gson.toJson(dataItems);

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    static ArrayList<CheckListFull> importFromJSONdata(Context context) {

        InputStreamReader streamReader = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = context.openFileInput(FILE_NAME);
            streamReader = new InputStreamReader(fileInputStream);
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(streamReader, DataItems.class);
            return  dataItems.getDataBase();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    static ArrayList<CheckListFull> importFromJSONassets(Context context) {



        InputStreamReader streamReader = null;
        try {
            AssetManager assetManager = context.getAssets();
            streamReader = new InputStreamReader(assetManager.open(FILE_NAME));
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(streamReader, DataItems.class);
            return dataItems.getDataBase();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return null;
    }

    private static class DataItems {
        private ArrayList<CheckListFull> dataBase;

        private ArrayList<CheckListFull> getDataBase() {
            return dataBase;
        }

        void setDataBase(ArrayList<CheckListFull> dataBase) {
            this.dataBase = dataBase;
        }
    }


}
