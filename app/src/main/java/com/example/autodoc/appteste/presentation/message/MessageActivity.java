package com.example.autodoc.appteste.presentation.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.autodoc.appteste.R;
import com.example.autodoc.appteste.presentation.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.text_mensagem)
    TextView textMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(HomeActivity.EXTRA_MESSAGE);

        textMensagem.setText(mensagem);

    }

}
