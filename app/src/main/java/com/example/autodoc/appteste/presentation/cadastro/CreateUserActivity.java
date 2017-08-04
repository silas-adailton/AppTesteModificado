package com.example.autodoc.appteste.presentation.cadastro;

import android.content.Context;
import android.content.Intent;
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
import dagger.android.AndroidInjection;

public class CreateUserActivity extends AppCompatActivity implements CreateUserContract.view {
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_senha)
    EditText editSenha;
    @BindView(R.id.progress_create_user)
    ProgressBar progress;

    @Inject
    CreateUserPresenter mPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, CreateUserActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        ButterKnife.bind(this);
        initializeDagger();
        progress.setVisibility(View.GONE);
    }

    private void initializeDagger() {
        AndroidInjection.inject(this);

    }

    @Override
    public void showMessageCreateUser() {
        Toast.makeText(this, "Usuario criado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageCreateUserError(Throwable e) {
        Toast.makeText(this, "Erro ao cria o usuario " + e.getMessage(), Toast.LENGTH_SHORT).show();
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
    public void showFieldEmailIsEmpty() {
        editEmail.setError(getString(R.string.msg_campo_obrigatorio));
    }

    @Override
    public void showFieldSenhaIsEmpty() {
        editSenha.setError(getString(R.string.msg_campo_obrigatorio));
    }

    @OnClick(R.id.button_send)
    void createUser() {
        mPresenter.createUser(getEmail(), getSenha());

    }

    private String getEmail() {
        String email = editEmail.getText().toString().toLowerCase().trim();
        ;
        return email;
    }

    private String getSenha() {
        String senha = editSenha.getText().toString().toLowerCase().trim();
        return senha;
    }
}
