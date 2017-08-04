package com.example.autodoc.appteste;

import com.example.autodoc.appteste.domain.message.Home;
import com.example.autodoc.appteste.domain.message.interactor.HomeInteractor;
import com.example.autodoc.appteste.presentation.home.HomeContract;
import com.example.autodoc.appteste.presentation.home.HomePresenter;

import org.junit.Before;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

public class HomePresenterTest {

    @Mock
    private HomeInteractor mHomeInteractor;

    @Mock
    private HomeContract.View mView;

    private HomePresenter mPresenter;

    @Before
    public void setupHomePresenter() {
        initMocks(this);

        mPresenter = new HomePresenter(mView, mHomeInteractor);
        mPresenter.setupListeners();
    }

//    @Test
//    public void saveMessageSucess(){
//
//
////        String msg = "Mensagem Teste";
////        Home home = new Home();
////        mPresenter.saveMessage(msg);
////
////        verify(mView).showProgress();
////        verify(mHomeInteractor).saveMessage(new HomeInteractor(mFirebaseRepository).saveMessage(home.getMensagem()));
////        verify(mView).showMessageSuccess();
////        verify(mView).hideProgress();
//
//    }

    public List<Home> getListMessage() {
        Home home = new Home("Teste de teste");

        List<Home> list = new ArrayList<>();
        list.add(home);

        return list;
    }
}
