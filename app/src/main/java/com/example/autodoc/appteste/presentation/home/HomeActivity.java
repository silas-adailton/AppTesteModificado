package com.example.autodoc.appteste.presentation.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.autodoc.appteste.R;
import com.example.autodoc.appteste.domain.message.Home;
import com.example.autodoc.appteste.presentation.message.MessageActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {
    public static final String EXTRA_MESSAGE = "com.example.autodoc.appteste.EXTRA_MENSAGEM";

    @BindView(R.id.text_mensagem)
    EditText mEditMessage;

    @BindView(R.id.button_enviar)
    Button mButtonSend;

    @BindView(R.id.progress_message)
    ProgressBar mProgressMessage;

    @BindView(R.id.recyclerViewMessage)
    RecyclerView recyclerViewMessage;

    @Inject
    HomePresenter mHomePresenter;
    HomeContract.Presenter mPresenter;
    private String mMensagem;
    private HomeRowAdapter mAdapter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mProgressMessage.setVisibility(View.GONE);

        initializeDagger();
        initializeRecyclerview();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.showListMessage();
    }

    private void initializeDagger() {
        AndroidInjection.inject(this);
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

    public void setmPresenter(HomeContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void showProgress() {
        mProgressMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressMessage.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(List<Home> list) {

        mAdapter = new HomeRowAdapter(list);
        recyclerViewMessage.setAdapter(mAdapter);
    }

    void initializeRecyclerview() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration divider = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerViewMessage.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessage.setHasFixedSize(true);
        recyclerViewMessage.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMessage.addItemDecoration(divider);


    }

    @OnClick(R.id.button_enviar)
    void enviarMensagem() {
        mMensagem = mEditMessage.getText().toString();
        mPresenter.save(mEditMessage.getText().toString());
        mPresenter.showListMessage();
    }

}
