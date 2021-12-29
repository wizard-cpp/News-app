package com.example.newsnow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Switch;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity  {
                 ArrayList<String> news=new ArrayList<>();
                 static ArrayList<String> http=new ArrayList<>();
                 ArrayList<String> image=new ArrayList<>();
                 RecyclerView recyclerView;
                 LinearLayoutManager layoutManager;
                 List<ModelClass>userList=new ArrayList<>();
                 JSONArray newsArray;
                 Adapter adapter;
                 private DatePickerDialog.OnDateSetListener setdate;
                 String dates;

    public void setItems(List<ModelClass> userList) {

        int currentSize = userList.size();
        userList.clear();
        userList.addAll(userList);
        adapter.notifyItemRangeRemoved(0,currentSize);
        adapter.notifyItemRangeInserted(0, userList.size());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.title3){


                downloadTask url = new downloadTask();

                url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&language=en,-de&categories=business&date=2021-05-25");
                setItems(userList);
                http.clear();
                image.clear();
            }


        if(item.getItemId()==R.id.title4){

                downloadTask url = new downloadTask();
                url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&language=en,-de&categories=sports&date=2021-05-25");
                setItems(userList);
                http.clear();
                image.clear();
            }


        if(item.getItemId()==R.id.title5){

                downloadTask url = new downloadTask();

                url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&language=en,-de&categories=health&date=2021-05-25");
                setItems(userList);
                http.clear();
                image.clear();
            }


        if(item.getItemId()==R.id.title6){

                downloadTask url = new downloadTask();

                url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&language=en,-de&categories=science&date=2021-05-25");
                setItems(userList);
                http.clear();
                image.clear();
            }


        if(item.getItemId()==R.id.title7){

                downloadTask url = new downloadTask();

                url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&language=en,-de&categories=technology&date=2021-05-25");
                setItems(userList);
                http.clear();
                image.clear();
            }






        if (item.getItemId() == R.id.title) {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(
                    this, android.R.style.Theme_Material_Dialog_Alert, setdate, year, month, day
            );
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
            dialog.show();
        }


            setdate = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    int monthcorrect = month + 1;
                    if (monthcorrect < 10) {

                        dates = year + "-" + "0" + monthcorrect + "-" + dayOfMonth;
                        Log.i("giyvi", dates);
                        downloadTask url = new downloadTask();
                        url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&date=" + dates + "&sources=cnn,-bcc");
                        setItems(userList);
                        http.clear();
                        image.clear();
                    } else {

                        dates = year + "-" + monthcorrect + "-" + dayOfMonth;

                        downloadTask url = new downloadTask();

                        url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&date=" + dates + "&sources=cnn,-bcc");
                        setItems(userList);
                        http.clear();
                        image.clear();
                    }
                }
            };


        return true;
    }


    public class imageDownload extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            HttpURLConnection webConnectionimage = null;
            URL image = null;
            try {
                image = new URL(strings[0]);
                webConnectionimage = (HttpURLConnection) image.openConnection();
                webConnectionimage.connect();
                InputStream in= webConnectionimage.getInputStream();
                Bitmap myImage = BitmapFactory.decodeStream(in);
                return myImage;

            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;

        }
    }
    public class imageDownload2 extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            HttpURLConnection webConnectionimage = null;
            URL image = null;
            try {
                image = new URL(strings[0]);
                webConnectionimage = (HttpURLConnection) image.openConnection();
                webConnectionimage.connect();
                InputStream in= webConnectionimage.getInputStream();
                Bitmap myImage2 = BitmapFactory.decodeStream(in);
                return myImage2;

            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;

        }
    }

    public class downloadTask  extends AsyncTask<String, Void,String> implements Adapter.OnNoteListner {

        @Override
        protected String doInBackground(String... strings) {

            try {
                StringBuilder result = new StringBuilder();
                HttpURLConnection webConnection = null;
                URL web = new URL(strings[0]);
                webConnection = (HttpURLConnection) web.openConnection();
                InputStream in = webConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    data = reader.read();
                    result.append(current);


                }

                return result.toString();
            } catch (IOException e) {
                e.printStackTrace();
                // textView.setText("ERROR!Please check your internet connection");

            }


            return "false";

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);
                String info = jsonObject.getString("pagination");

                /* textView.setText(info);*/
                JSONObject fuck = jsonObject.getJSONObject("pagination");
                newsArray = jsonObject.getJSONArray("data");


                for (int i = 0; i < newsArray.length(); i++) {
                    //news.add(newsArray.getString(i));
                    JSONObject title = newsArray.getJSONObject(i);


                    // news.add(title.getString("title"));

                    http.add(title.getString("url"));

                    image.add(title.getString("image"));

                    imageDownload task = new imageDownload();
                    Bitmap icon;
                    try {

                        icon = task.execute(image.get(i)).get();

                        if (icon != null) {

                            userList.add(new ModelClass(icon, title.getString("title")));

                        } else {
                            imageDownload2 imagetask = new imageDownload2();
                            Bitmap noload;
                            noload = imagetask.execute("https://www.cyclonis.com/images/2018/09/newsnow-data-breach.jpg").get();
                            userList.add(new ModelClass(noload, title.getString("title")));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    layoutManager = new LinearLayoutManager(MainActivity.this);
                    layoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new Adapter(userList, this);
                    recyclerView.setAdapter(adapter);

            }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onNoteClick(int position) {

                userList.get(position);
                Intent intent = new Intent(getApplicationContext(), secondActivity.class);
                intent.putExtra("httpID", position);
                startActivity(intent);

        }
    }

            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listView=findViewById(R.id.listView);
        recyclerView=findViewById(R.id.recyclerView);




        Date calendar=Calendar.getInstance().getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault());
                String date= dateFormat.format(calendar);

        downloadTask url=new downloadTask();
                 url.execute("http://api.mediastack.com/v1/news?access_key=acc9dc78f768bf07e16db14a3bbe8242&date="+date+"&sources=cnn,-bcc");



    }
}