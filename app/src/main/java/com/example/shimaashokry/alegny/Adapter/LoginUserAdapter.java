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

public class LoginUserAdapter extends AsyncTask<String,Void,String> {

    LogIn ctx;
    public LoginUserAdapter(LogIn ctx){
        this.ctx = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        String login_url = "https://3alegnymobileapp.000webhostapp.com/login.php";
        String Name = strings[0];
        String Pass = strings[1];
        try {
            URL url =new URL (login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
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
    protected void onPostExecute(String s) {
        /*alertDialog.setMessage(s);
        alertDialog.show();*/

        Toast.makeText(ctx,s,Toast.LENGTH_LONG).show();
        if(s.equals("Login Success..."))
        {
            ctx.display();
        }
    }
}