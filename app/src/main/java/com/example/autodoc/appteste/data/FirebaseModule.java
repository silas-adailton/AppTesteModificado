package com.example.autodoc.appteste.data;

import com.google.firebase.auth.FirebaseAuth;
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

    @Provides
    FirebaseAuth getFireAuth() {
        return FirebaseAuth.getInstance();
    }

   /* @Provides
    FirebaseAuth.AuthStateListener getAuthStateListener(FirebaseAuth.AuthStateListener authStateListener){
        return (FirebaseAuth.AuthStateListener) FirebaseAuth.getInstance();
    }*/

    /*@Provides
    RepositoryUser getRepositoryUser(FirebaseAuth auth,FirebaseAuth.AuthStateListener authStateListener){
        return new FirebaseRepositoryUser(auth,authStateListener);
    }*/

    @Provides
    RepositoryUser getRepositoryUser(FirebaseAuth auth) {
        return new FirebaseRepositoryUser(auth);
    }


}
