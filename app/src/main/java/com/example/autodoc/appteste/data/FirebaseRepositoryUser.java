package com.example.autodoc.appteste.data;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.autodoc.appteste.domain.message.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class FirebaseRepositoryUser implements RepositoryUser {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    /* @Inject
     public FirebaseRepositoryUser(FirebaseAuth mAuth, FirebaseAuth.AuthStateListener mAuthStateListener) {
         this.mAuth = mAuth;
         this.mAuthStateListener = mAuthStateListener;
     }*/
    @Inject
    public FirebaseRepositoryUser(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    @Override
    public Observable<User> sigIn(User user) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(mAuthStateListener);

        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {

                            emitter.onNext(user);
                            emitter.onComplete();

                            Log.w("onComplete: ", task.getException());
                            //Toast.makeText(LoginActivity.this, "Falha no login " + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Erro", "onFailure: " + e.getMessage());
                        emitter.onError(e);

                    }
                });

            }
        });

    }
}
