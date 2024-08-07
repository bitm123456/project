package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix,
            btnSeven, btnEight, btnNine, btnZero;
    Button btnSave, btnDel, btnStar, btnHash, btnCall;
    EditText txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = (Button) findViewById(R.id.btn_one);
        btnOne.setOnClickListener(this);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnTwo.setOnClickListener(this);
        btnThree = (Button) findViewById(R.id.btn_three);
        btnThree.setOnClickListener(this);
        btnFour = (Button) findViewById(R.id.btn_four);
        btnFour.setOnClickListener(this);
        btnFive = (Button) findViewById(R.id.btn_five);
        btnFive.setOnClickListener(this);
        btnSix = (Button) findViewById(R.id.btn_six);
        btnSix.setOnClickListener(this);
        btnSeven = (Button) findViewById(R.id.btn_seven);
        btnSeven.setOnClickListener(this);
        btnEight = (Button) findViewById(R.id.btn_eight);
        btnEight.setOnClickListener(this);
        btnNine = (Button) findViewById(R.id.btn_nine);
        btnNine.setOnClickListener(this);
        btnZero = (Button) findViewById(R.id.btn_zero);
        btnZero.setOnClickListener(this);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        btnCall = (Button) findViewById(R.id.btn_call);
        btnCall.setOnClickListener(this);
        btnHash = (Button) findViewById(R.id.btn_hash);
        btnHash.setOnClickListener(this);
        btnStar = (Button) findViewById(R.id.btn_star);
        btnStar.setOnClickListener(this);
        btnDel = (Button) findViewById(R.id.btn_delete);
        btnDel.setOnClickListener(this);
        txtPhone = (EditText)
                findViewById(R.id.txt_phonenumber);
        txtPhone.setText("");
    }
    @Override
    public void onClick(View v) {
        if (v.equals(btnOne))
            txtPhone.append("1");
        else if (v.equals(btnTwo))
            txtPhone.append("2");
        else if (v.equals(btnThree))
            txtPhone.append("3");
        else if (v.equals(btnFour))
            txtPhone.append("4");
        else if (v.equals(btnFive))
            txtPhone.append("5");
        else if (v.equals(btnSix))
            txtPhone.append("6");
        else if (v.equals(btnSeven))
            txtPhone.append("7");
        else if (v.equals(btnEight))
            txtPhone.append("8");
        else if (v.equals(btnNine))
            txtPhone.append("9");
        else if (v.equals(btnZero))
            txtPhone.append("0");
        else if (v.equals(btnHash))
            txtPhone.append("#");
        else if (v.equals(btnStar))
            txtPhone.append("*");
        else if (v.equals(btnSave)) {
            Intent contactIntent = new
                    Intent(ContactsContract.Intents.Insert.ACTION);

            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
            ;

            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,
                    "Parveen");

            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,
                    txtPhone.getText().toString());
            startActivity(contactIntent);
        } else if (v.equals(btnDel)) {
            String data = txtPhone.getText().toString();
            if (data.length() > 0)
                txtPhone.setText(data.substring(0, data.length()
                        - 1));
            else
                txtPhone.setText("");
        }
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = txtPhone.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + data));
                startActivity(i);
            }
        });
    }
}
