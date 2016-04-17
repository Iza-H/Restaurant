package io.projectandroid.restaurant.model;


import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by izabela on 16/04/16.
 */
public class Menu implements Serializable{
    private ArrayList<Meal> listMeals;

    public Menu() {
    }

    public Menu(ArrayList <Meal> listMeals) {
        this.listMeals = listMeals;
    }

    public ArrayList<Meal> getListMeals() {
        return listMeals;
    }

    public void setListMeals(ArrayList<Meal> listMeals) {
        this.listMeals =  listMeals;
    }

    /*private City mCity;


    private void downloadMeal(){
       AsyncTask<City, Integer, Menu> mealsDownloader = new AsyncTask<City, Integer, Menu>() {
           @Override
           protected void onPreExecute() {
               super.onPreExecute();
               //Hilo principal
               mViewSwitcher.setDispalyChild(0);
           }

           @Override
            protected Menu doInBackground(City... params) {
               mCity = params[0];
               URL url = null;
               InputStream input = null;

               try{
                   url = new URL(String.format(), city.getName());
                   HttpURLConnection con = (HttpURLConnection) url.openConnection();
                   con.connect();
                   int responseLength = con.getContentLength();
                   byte data[] = new byte[1024];
                   long currentBytes = 0;
                   int downloadedBytes;
                   input = con.getInputStream();
                   StringBuilder sb = new StringBuilder();
                   while ((downloadedBytes=input.read(data))!=-1){
                       sb.append(new String(data, 0, downloadedBytes));
                       if (responseLength>0){
                           currentBytes+=downloadedBytes;
                           publishProgress((int)(currentBytes *100)/responseLength);

                       }
                   }
                   JSONObject jsonRoot = new JSONObject(sb.toString());
                   JSONArray days = jsonRoot.getJSONArray("list");
                   JSONObject today = days.getJSONObject(0);
                   float max = (float) today.getJSONObject("temp").getDouble("max");

                   return new Forecast();

               }catch (Exception ex){
                   ex.printStackTrace();
               }
               finally{
                   if (input!=null){
                       try {
                           input.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }
                return null;
            }

           @Override
           protected void onProgressUpdate(Integer... values) {
               super.onProgressUpdate(values);
               mProgress.setProgress(values[0]);

           }

           @Override
           protected void onPostExecute(Menu meals) {
               super.onPostExecute(meals);
               //Hilo principal
               if (meals!=null){
                   city.setForecast(forecast);
                   updateCityInfo();
               }else{
                   AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                   alert.setTitle("Error");
                   alert.setMessage("No se pudo descargaf la información");
                   alert.setPositiveButton("Reintenar", new DialogInterface.OnClickListener(){
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                            downloadMeal();
                       }
                   });
                   alert.setPositiveButton("Regresar", new DialogInterface.OnClickListener(){

                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                            getActivity().finish();
                       }
                   });
                   alert.show();
               }


           }
       };

       mealsDownloader.execute(mCity);




    }*/
}

