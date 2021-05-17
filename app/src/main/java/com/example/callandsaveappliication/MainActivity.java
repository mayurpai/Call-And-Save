package com.example.callandsaveappliication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistryOwner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9; // (1-9)
    Button button10,button11,button12; // 0#*
    Button button13,button14; // Call And Save
    Button button; // Delete
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        editText = findViewById(R.id.editText);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editText.getText().toString();
                if(phone.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter The Phone Number!", Toast.LENGTH_SHORT).show();
                    Log.d("Activity","Error");
                }
                else {
                    String s = "tel:" + phone;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(s));
                    if(intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "There Is No App That Support's This Action!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editText.getText().toString();
                if(phone.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter The Phone Number!", Toast.LENGTH_SHORT).show();
                    Log.d("Activity","Error");
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "There Is No App That Support's This Action!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void zero (View view){
        editText.setText(editText.getText() + "0");
    }
    public void one (View view){
        editText.setText(editText.getText() + "1");
    }
    public void two (View view){
        editText.setText(editText.getText() + "2");
    }
    public void three (View view){
        editText.setText(editText.getText() + "3");
    }
    public void four (View view){
        editText.setText(editText.getText() + "4");
    }
    public void five (View view){
        editText.setText(editText.getText() + "5");
    }
    public void six (View view){
        editText.setText(editText.getText() + "6");
    }
    public void seven (View view){
        editText.setText(editText.getText() + "7");
    }
    public void eight (View view){
        editText.setText(editText.getText() + "8");
    }
    public void nine (View view){
        editText.setText(editText.getText() + "9");
    }
    public void delete (View view) {editText.setText("");}
    public void hash (View view) {editText.setText(editText.getText() + "#");}
    public void star (View view) {editText.setText(editText.getText() + "*");}
}