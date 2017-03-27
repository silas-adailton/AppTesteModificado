package com.example.autodoc.appteste.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.autodoc.appteste.domain.message.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class FirebaseRepositoryUser implements RepositoryUser {
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authStateListener;

    @Inject
    public FirebaseRepositoryUser(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    @Override
    public Observable<User> createUser(User user) {
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                emitter.onNext(user);
                                emitter.onComplete();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        emitter.onError(e);
                    }
                });
            }
        });
    }

    @Override
    public Observable sigIn(User user) {

        return Observable.create(emitter -> {
            if (user != null) {

                mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseUser user1 = mAuth.getCurrentUser();
                                Log.d("", "sigIn: " + user1.getEmail());

                                emitter.onNext(user1);
                                emitter.onComplete();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        emitter.onError(e);
                    }
                });
            }
        });

    }

}
