package com.example.autodoc.appteste.presentation.cadastro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.autodoc.appteste.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateUserActivity extends AppCompatActivity implements CreateUserContract.view {
    @BindView(R.id.edit_nome)
    EditText editNome;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_senha)
    EditText editSenha;
    @BindView(R.id.progress_create_user)
    ProgressBar progress;

    @Inject
    CreateUserPresenter mPresenter;
    CreateUserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        ButterKnife.bind(this);
        initializerDagger();
        progress.setVisibility(View.GONE);
    }

    private void initializerDagger() {

    }

    @Override
    public void showMessageCreateUser() {
        Toast.makeText(this, "Usuario criado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageCreateUserError() {
        Toast.makeText(this, "Erro ao cria o usuario", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(CreateUserContract.Presenter presenter) {
        this.presenter = mPresenter;
    }

    @Override
    public void showFieldIsEmpty() {

    }

    @OnClick(R.id.button_send)
    void createUser() {

    }
}
