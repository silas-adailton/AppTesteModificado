package com.example.autodoc.appteste.data;

import android.support.annotation.NonNull;

import com.example.autodoc.appteste.domain.message.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class FirebaseRepository implements Repository {

    private DatabaseReference mDatabaseReference;

    @Inject
    public FirebaseRepository(DatabaseReference databaseReference) {
        this.mDatabaseReference = databaseReference;
    }

    @Override
    public Observable<Home> saveMessage(Home home) {
        return Observable.create(new ObservableOnSubscribe<Home>() {
            @Override
            public void subscribe(ObservableEmitter<Home> emitter) throws Exception {

                String mensagemId = mDatabaseReference.push().getKey();
                mDatabaseReference.child(mensagemId).setValue(home).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        emitter.onNext(home);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        emitter.onError(e);

                    }
                }).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        emitter.onComplete();
                    }
                });

            }
        });
    }

    @Override
    public Observable<List<Home>> listMessage() {

        List<Home> list = new ArrayList<Home>();
        return Observable.create(new ObservableOnSubscribe<List<Home>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Home>> emitter) throws Exception {
                mDatabaseReference.getDatabase().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        GenericTypeIndicator<Map<String, Home>> typeIndicator = new GenericTypeIndicator<Map<String, Home>>() {
                        };
                        Map<String, Home> map = dataSnapshot.getValue(typeIndicator);

                        for (String key : map.keySet()) {
                            list.add(map.get(key));

                        }

                        emitter.onNext(list);
                        emitter.onComplete();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        emitter.onError(databaseError.toException());

                    }
                });

            }
        });
    }

    @Override
    public void saveMessage(Home home, final RepositoryExecutor repositoryExecutor) {
        String mensagemId = mDatabaseReference.child("Mensagens").push().getKey();
        mDatabaseReference.child(mensagemId).setValue(home)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        repositoryExecutor.onSuccess(true);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                repositoryExecutor.onError(e);
            }
        }).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                repositoryExecutor.onCompleted();
            }
        });
    }

    @Override
    public void listar(final RepositoryExecutor repositoryExecutor) {
        final ArrayList<Object> listMessage = new ArrayList<>();

        mDatabaseReference.getDatabase().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String, Home>> map = new GenericTypeIndicator<Map<String, Home>>() {
                };
                Map<String, Home> lista = dataSnapshot.getValue(map);

                for (String key : lista.keySet()) {

                    listMessage.add(lista.get(key));

                }

                repositoryExecutor.onSuccess(listMessage);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                repositoryExecutor.onError(databaseError.toException());

            }
        });

    }


}
