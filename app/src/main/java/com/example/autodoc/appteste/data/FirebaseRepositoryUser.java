package com.example.autodoc.appteste.data;

import android.support.annotation.NonNull;

import com.example.autodoc.appteste.domain.message.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import io.reactivex.Observable;

public class FirebaseRepositoryUser implements RepositoryUser {
    FirebaseAuth mAuth;

    @Inject
    public FirebaseRepositoryUser(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    @Override
    public Observable<User> sigIn(User user) {

        return Observable.create(emitter -> {
            if (user != null) {
                mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
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
}
