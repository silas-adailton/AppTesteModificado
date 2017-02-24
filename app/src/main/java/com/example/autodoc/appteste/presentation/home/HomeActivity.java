package com.example.autodoc.appteste.presentation.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.autodoc.appteste.MainApplication;
import com.example.autodoc.appteste.R;
import com.example.autodoc.appteste.presentation.message.MessageActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {
    public static final String EXTRA_MESSAGE = "com.example.autodoc.appteste.EXTRA_MENSAGEM";

    @BindView(R.id.text_mensagem)
    EditText mEditMessage;

    @BindView(R.id.button_enviar)
    Button mButtonSend;

    @BindView(R.id.progress_message)
    ProgressBar mProgressMessage;
    @Inject
    HomePresenter mHomePresenter;
    HomeContract.Presenter presenter;
    private String mMensagem;

    @OnClick(R.id.button_enviar)
    void enviarMensagem() {
        mMensagem = mEditMessage.getText().toString();
        presenter.saveMessage(mEditMessage.getText().toString());
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
                .mainComponent(MainApplication.getsMainComponent())
                .repositoryComponent(MainApplication.getsRepositoryComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);

    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorFieldEmpty() {
        Toast.makeText(this, getString(R.string.message), Toast.LENGTH_SHORT).show();
        mEditMessage.setError(getString(R.string.message));
    }

    @Override
    public void showMessageSuccess() {
        Toast.makeText(this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openDisplayMessageActivity() {
        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mMensagem);
        startActivity(intent); 

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {
        mProgressMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressMessage.setVisibility(View.GONE);
    }


}
