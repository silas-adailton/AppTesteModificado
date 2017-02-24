package com.example.autodoc.appteste.data;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;

import javax.inject.Inject;

public class FirebaseRepository implements Repository {

    private DatabaseReference mDatabaseReference;

    @Inject
    public FirebaseRepository(DatabaseReference databaseReference) {
        this.mDatabaseReference = databaseReference;
    }

    @Override
    public void saveMessage(String msg, final RepositoryExecutor repositoryExecutor) {
        String mensagemId = mDatabaseReference.child("Mensagens").push().getKey();
        mDatabaseReference.child(mensagemId).setValue(msg)
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
    public void listar() {

    }

   /* @Provides
    public FirebaseDatabase provideFirebaseDatabase(){
        return FirebaseDatabase.getInstance();
    }
    @Provides
    public DatabaseReference provideFirebaseDatabase(FirebaseDatabase firebaseDatabase){
        return firebaseDatabase.getReference();
    }*/
}
