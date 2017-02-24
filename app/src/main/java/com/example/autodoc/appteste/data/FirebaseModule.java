package com.example.autodoc.appteste.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    @Provides
    DatabaseReference getDataBaseReference() {
        return FirebaseDatabase.getInstance().getReference();
    }

    @Provides
    Repository getRepository(DatabaseReference databaseReference) {
        return new FirebaseRepository(databaseReference);
    }
}
