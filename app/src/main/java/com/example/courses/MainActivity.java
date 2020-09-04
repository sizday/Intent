package com.example.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bOK1;
    Button bOK2;
    Button bOK3;
    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bOK1 = findViewById(R.id.button);
        bOK2 = findViewById(R.id.button2);
        bOK2 = findViewById(R.id.button3);
    }

    public void composeEmail(String addresses, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClick(View v) {
        edit1 = findViewById(R.id.editText);
        Intent push = new Intent(MainActivity.this, ResultActivity.class);
        push.putExtra("result", edit1.getText().toString());
        if (push.resolveActivity(getPackageManager()) != null) {
            startActivity(push);
        }
    }

    public void onClick1(View v) {
        Uri myPage = Uri.parse("https://vk.com/1denis9");
        Intent push = new Intent(Intent.ACTION_VIEW, myPage);
        if (push.resolveActivity(getPackageManager()) != null) {
            startActivity(push);
        } else {
            System.out.println("error");
        }
    }

    public void onClick2(View v) {
        Uri contact = ContactsContract.Contacts.CONTENT_URI;
        Intent push = new Intent(Intent.ACTION_VIEW, contact);
        if (push.resolveActivity(getPackageManager()) != null) {
            startActivity(push);
        } else {
            System.out.println("error");
        }
    }

    public void onClick3(View v) {
        composeEmail("dsizov1999@mail.ru", "title", "kjsgyfsdkfgyvsdsdfsdfdsf");
    }
}
