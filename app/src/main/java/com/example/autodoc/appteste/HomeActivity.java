package com.example.autodoc.appteste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements HomeContract.HomeContractView {
    public static final String EXTRA_MESSAGE = "com.example.autodoc.appteste.EXTRA_MENSAGEM";

    @BindView(R.id.editMensagem)
    EditText editMessage;
    @BindView(R.id.btnEnviar)
    Button btnEnviar;
    private String mensagem;

    @Inject
    HomeContract.HomeContractPresenter presenter;

    @OnClick(R.id.btnEnviar)
    void enviarMensagem() {
        mensagem = editMessage.getText().toString();
        presenter.validaCampo(mensagem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initDagger();

    }

    private void initDagger() {
        DaggerHomeComponent.builder()
                .homeViewModule(new HomeViewModule(this))
                .homePresenterModule(new HomePresenterModule())
                .build()
                .inject(this);
    }


    @Override
    public void errorMessage() {
        Toast.makeText(this, getString(R.string.message), Toast.LENGTH_SHORT).show();
        editMessage.setError(getString(R.string.message));
    }

    @Override
    public void sucess() {
        Toast.makeText(this, getString(R.string.Validado), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void openDisplayMessageActivity() {
        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mensagem);
        startActivity(intent);

    }

    @Override
    public void setPresenter(HomeContract.HomeContractPresenter presenter) {
        this.presenter = presenter;
    }

}
