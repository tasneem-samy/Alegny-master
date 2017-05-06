package com.example.shimaashokry.alegny.Adapter;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.shimaashokry.alegny.Domain.Device;
import com.example.shimaashokry.alegny.Domain.Hospital;
import com.example.shimaashokry.alegny.SearchPage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class SearchByNameAdapter extends AsyncTask<String, Void, String> {

    String search_url;
    SearchPage ctx;
    public SearchByNameAdapter(SearchPage ctx){
        this.ctx = ctx;
    }
    @Override
    protected void onPreExecute() {
        search_url = "http://3alegnymobileapp.000webhostapp.com/get_by_name.php";
    }

    @Override
    protected String doInBackground(String... params) {
        String name = params[0];
        try {
            URL url =new URL (search_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream OS = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
            String data = URLEncoder.encode("Name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            OS.close();
            InputStream IS =httpURLConnection.getInputStream();
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(IS));
            StringBuilder stringBuilder = new StringBuilder();
            String json_string;
            while ((json_string= bufferedReader.readLine())!= null)
            {
                stringBuilder.append(json_string+"/n");
            }
            bufferedReader.close();
            IS.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();
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

        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray=jsonObject.getJSONArray("hospital");
            int count = 0;
            while (count<jsonArray.length()) {
                JSONObject Jo = jsonArray.getJSONObject(count);
                String name = Jo.getString("name");
                String address = Jo.getString("address");
                int ticket = Jo.getInt("ticket");
                String website = Jo.getString("website");
                JSONArray Ja=Jo.getJSONArray("phone");
                int phones[] = new int[Ja.length()];
                for(int i=0; i<Ja.length();i++){
                    phones[i] = Ja.getInt(i);
                }
                JSONArray ja=Jo.getJSONArray("departments");
                String deps[] = new String[ja.length()];
                for(int i=0; i<ja.length();i++){
                    deps[i] = ja.getString(i);
                }
                JSONArray j=Jo.getJSONArray("Devices");
                Device device[] = new Device[j.length()];
                for(int i=0; i<j.length();i++){
                    JSONObject n = j.getJSONObject(i);
                    device[i]=new Device( n.getString("Device"),n.getString("Description"));
                }
                Hospital hospital = new Hospital(name, address, website, deps, ticket, phones, device);
                ctx.display(hospital);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}