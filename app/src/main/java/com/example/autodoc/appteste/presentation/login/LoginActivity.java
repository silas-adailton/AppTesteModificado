package com.example.autodoc.appteste.presentation.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.autodoc.appteste.MainApplication;
import com.example.autodoc.appteste.R;
import com.example.autodoc.appteste.presentation.home.HomeActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        progressLogin.setVisibility(View.GONE);
        initializeDagger();

    }

    private void initializeDagger() {
        DaggerLoginComponent.builder()
                .mainComponent(MainApplication.getsMainComponent())
                .repositoryComponent(MainApplication.getsRepositoryComponent())
                .loginModule(new LoginModule(this))
                .build().inject(this);
    }

    /*private Observable initializeMauthStateListener() {
        mAuth = FirebaseAuth.getInstance();

        return Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();

                        if (user != null) {
                            emitter.onNext(user);
                            emitter.onComplete();
                            Toast.makeText(LoginActivity.this, "Logado com sucesso " + user.getUid(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login ou senha invalidos", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
            }
        });
    }*/

   /* private Observable sigIn(String login, String password) {
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> e) throws Exception {
                mAuth.signInWithEmailAndPassword(login, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(LoginActivity.this, "Login completo " + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()) {
                                    Log.w("onComplete: ", task.getException());
                                    Toast.makeText(LoginActivity.this, "Falha no login " + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        }).subscribe(DisposableSingleObserver);

    }*/

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

    @Override
    public void openHomeMessage() {
        startActivity(HomeActivity.getStartIntent(this));
    }

    @OnClick(R.id.button_login)
    void Login() {
        presenter.sigIn(mEditEmail.getText().toString().toLowerCase().trim(), mEditPassword.getText().toString().toLowerCase().trim());

    }
}
