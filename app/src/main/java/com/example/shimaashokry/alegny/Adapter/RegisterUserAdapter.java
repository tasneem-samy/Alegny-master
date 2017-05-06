package com.example.shimaashokry.alegny.Adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.shimaashokry.alegny.LogIn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by tasneem on 06/05/2017.
 */

public class RegisterUserAdapter extends AsyncTask<String, Void, String> {

    LogIn ctx;
    public RegisterUserAdapter(LogIn ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String register_url = "http://3alegnymobileapp.000webhostapp.com/register.php";
        String Name = strings[0];
        String Pass = strings[1];
        try {
            URL url =new URL (register_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
            String data = URLEncoder.encode("Name","UTF-8")+"="+URLEncoder.encode(Name,"UTF-8")+"&"+URLEncoder.encode("Pass","UTF-8")+"="+URLEncoder.encode(Pass,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS =httpURLConnection.getInputStream();
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(IS,"UTF-8"));
            String responce = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                responce += line;
            }
            bufferedReader.close();
            IS.close();
            httpURLConnection.disconnect();
            return responce;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
        if(result.equals("Database Insertion Success...")){
            ctx.display();
        }
    }
}
