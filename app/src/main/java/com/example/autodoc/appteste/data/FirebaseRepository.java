package com.example.autodoc.appteste.data;

import android.support.annotation.NonNull;

import com.example.autodoc.appteste.domain.home.Home;
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
import java.util.Map;

import javax.inject.Inject;

public class FirebaseRepository implements Repository {

    private DatabaseReference mDatabaseReference;

    @Inject
    public FirebaseRepository(DatabaseReference databaseReference) {
        this.mDatabaseReference = databaseReference;
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
