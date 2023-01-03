package com.guy.class23a_and_6;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Arrays;
import java.util.List;

public class Activity_Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();



        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            login();
        } else {
            String uid = user.getUid();
            String phone = user.getPhoneNumber();
            String name = user.getDisplayName();
            String xx = name + " ";
            int x = 0;
        }

        user.updateProfile(
                new UserProfileChangeRequest.Builder()
                .setDisplayName("Guy Isakov")
                .build());

    }

    private void login() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build()
        );

        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build();


        signInLauncher.launch(signInIntent);
    }

    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );

    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        int x = 0;
        int y = x+ 9;

    }
}

/*


Afghanistan (+93)
Albania (+355)
Algeria (+213)
American Samoa (+1)
Andorra (+376)
Angola (+244)
Anguilla (+1)
Antarctica (+672)
Antigua and Barbuda (+1)
Argentina (+54)
Armenia (+374)
Aruba (+297)
Australia (+61)
Austria (+43)
Azerbaijan (
 */