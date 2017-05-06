package com.example.shimaashokry.alegny;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.shimaashokry.alegny.Adapter.SearchByNameAdapter;
import com.example.shimaashokry.alegny.Domain.Hospital;

public class SearchPage extends AppCompatActivity {

    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        text = (EditText) findViewById(R.id.editText3);
    }

    public void searchHospital(View view) {
        String name = text.getText().toString();
        SearchByNameAdapter r = new SearchByNameAdapter(this);
        r.execute(name);
    }

    public void display(Hospital hospital){
        Intent i =new Intent(this,DisplayPage.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("hospital",hospital);
        i.putExtras(bundle);
        startActivity(i);
    }
}
