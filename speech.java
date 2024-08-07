package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, TextToSpeech.OnInitListener {
    EditText txt;
    Button btnSp;
    TextToSpeech txtSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (EditText) findViewById(R.id.editText);
        btnSp = (Button) findViewById(R.id.btn_speak);
        btnSp.setOnClickListener(this);
        txtSp = new TextToSpeech(getBaseContext(),this);
        txtSp.setLanguage(Locale.UK);
    }

    @Override
    public void onClick(View v) {
        String text = txt.getText().toString();
        txtSp.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }
    @Override
    public void onInit(int status) {
        if(status!= TextToSpeech.ERROR){

            Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_LONG).show();
        }
    }
}
