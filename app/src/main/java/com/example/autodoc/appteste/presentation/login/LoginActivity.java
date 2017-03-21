package com.example.autodoc.appteste.presentation.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.autodoc.appteste.MainApplication;
import com.example.autodoc.appteste.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {
    @BindView(R.id.edit_login)
    EditText mEditEmail;
    @BindView(R.id.edit_senha)
    EditText mEditPassword;
    @BindView(R.id.progress_login)
    ProgressBar progressLogin;

    @Inject
    LoginPresenter presenter;
    LoginContract.presenter mLoginContractPresenter;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        progressLogin.setVisibility(View.GONE);

        initializeDagger();

        // initializeMauthStateListener();

    }

    private void initializeDagger() {
        DaggerLoginComponent.builder()
                .mainComponent(MainApplication.getsMainComponent())
                .repositoryComponent(MainApplication.getsRepositoryComponent())
                .loginModule(new LoginModule(this))
                .build().inject(this);

    }

    /*private void initializeMauthStateListener() {
        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    Toast.makeText(LoginActivity.this, "Logado com sucesso " + user.getUid(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login ou senha invalidos", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }*/

   /* private void sigIn(String login, String password) {
        mAuth.signInWithEmailAndPassword(login, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LoginActivity.this, "Login completo " + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                        if (!task.isSuccessful()) {
                            Log.w("onComplete: ", task.getException());
                            Toast.makeText(LoginActivity.this, "Falha no login " + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }*/

    @Override
    protected void onStart() {
        super.onStart();

        //mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

      /*  if (mAuthStateListener != null) {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }*/
    }

    @Override
    public void showMessageErrorEmailEmpty() {
        mEditEmail.setError(getString(R.string.msg_campo_obrigatorio));
    }

    @Override
    public void showMessageErrorPasswordEmpty() {
        mEditPassword.setError(getString(R.string.msg_campo_obrigatorio));
    }

    @Override
    public void showMessageErrorLogin(Throwable e) {
        Toast.makeText(this, "" + getString(R.string.msg_error_login), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mauthStateListener() {

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    Toast.makeText(LoginActivity.this, "Logado com sucesso " + user.getUid(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login ou senha invalidos", Toast.LENGTH_SHORT).show();
                }
            }
        };

    }

    @Override
    public void showProgress() {
        progressLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressLogin.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(LoginContract.presenter presenter) {
        this.mLoginContractPresenter = presenter;
    }

    @OnClick(R.id.button_login)
    void Login() {
        presenter.sigIn(mEditEmail.getText().toString(), mEditPassword.getText().toString());
    }
}
