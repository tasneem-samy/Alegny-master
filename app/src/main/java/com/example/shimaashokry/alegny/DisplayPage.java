package com.example.shimaashokry.alegny;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shimaashokry.alegny.Domain.Hospital;

public class DisplayPage extends AppCompatActivity {

    TextView name, phone, address, price, devices, dept, website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);
        Bundle bundle = getIntent().getExtras();
        Hospital hospital =(Hospital) bundle.getSerializable("hospital");
        name =(TextView) findViewById(R.id.text1);
        phone =(TextView) findViewById(R.id.text2);
        address =(TextView) findViewById(R.id.text3);
        price =(TextView) findViewById(R.id.text4);
        devices =(TextView) findViewById(R.id.text5);
        dept =(TextView) findViewById(R.id.text6);
        website =(TextView) findViewById(R.id.text7);

        name.setText(hospital.getName());
        for(int i = 0; i<hospital.getPhone().length;i++)
        {
            phone.setText(phone.getText().toString()+hospital.getPhone()[i]+"\n");
        }
        address.setText(hospital.getAddress());

        price.setText(String.valueOf(hospital.getTicket()));
        for(int i = 0; i<hospital.getDevice().length;i++)
        {
            devices.setText(devices.getText().toString()+hospital.getDevice()[i].getDeviceName()+"__"+hospital.getDevice()[i].getDeviceDescription()+"\n\n");
        }
        for(int i = 0; i<hospital.getDepartment().length;i++)
        {
            dept.setText(dept.getText().toString()+hospital.getDepartment()[i]+"\n");
        }
        website.setText(hospital.getWebsite());
    }
}
