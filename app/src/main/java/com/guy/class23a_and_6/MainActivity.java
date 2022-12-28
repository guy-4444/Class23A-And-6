package com.guy.class23a_and_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView main_LBL_top;
    private MaterialButton main_BTN_updateUserName;
    private MaterialButton main_BTN_gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_BTN_updateUserName = findViewById(R.id.main_BTN_updateUserName);
        main_BTN_gameOver = findViewById(R.id.main_BTN_gameOver);
        main_LBL_top = findViewById(R.id.main_LBL_top);


        main_BTN_updateUserName.setOnClickListener(v -> updateCar());
        main_BTN_gameOver.setOnClickListener(v -> readSCar("44455666"));


        updateTopScoreValue();
    }

    private void updateCarInGarage(String license, boolean status) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("garage");
        ref.child("cars").child(license).child("fourWD").setValue(status);
    }

    private void readSCar(String license) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("garage");
        ref.child("cars").child(license).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Car c = dataSnapshot.getValue(Car.class);

                main_LBL_top.setText(c.getModel() + "\n" + c.getLicense() + "\n" + c.getType());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("pttt", "Failed to read value.", error.toException());
            }
        });
    }

    private void readCar() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("Car");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Car c = dataSnapshot.getValue(Car.class);

                main_LBL_top.setText(c.getModel() + "\n" + c.getLicense() + "\n" + c.getType());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("pttt", "Failed to read value.", error.toException());
            }
        });
    }

    private void updateCar() {

        Garage garage = new Garage().setAddress("Mivtza Kadesh 38");
        garage.getCars().put("11122333"
                , new Car("11122333")
                        .setModel("Mercedes S500")
                        .setKm(0)
                        .setKml(5.6)
                        .setPrice(560000)
                        .setFourWD(false)
                        .setType(Car.TYPE.HYBRID));

        garage.getCars().put("44455666", new Car("44455666")
                .setModel("Ford Mustang")
                .setKm(0)
                .setKml(15.6)
                .setPrice(560000)
                .setFourWD(true)
                .setType(Car.TYPE.GAS));

        garage.getCars().put("6677788", new Car("6677788")
                .setModel("Tesla 3")
                .setKm(1110)
                .setPrice(560000)
                .setFourWD(false)
                .setType(Car.TYPE.ELECTRIC));


        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("garage");
        ref.setValue(garage);
    }

    private void updateTopScoreValue() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("Top Score");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.getValue(Integer.class);
                if (value != null) {
                    main_LBL_top.setText("" + value);
                } else {
                    main_LBL_top.setText("NA");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("pttt", "Failed to read value.", error.toException());
            }
        });
    }

    private void gameOver() {
        int score = 2000;

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("Top Score");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.getValue(Integer.class);
                if (value != null) {
                    if (value < score) {
                        updateTopScore(score);
                    }
                } else {
                    updateTopScore(score);
                }
                Log.d("pttt", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("pttt", "Failed to read value.", error.toException());
            }
        });


    }

    private void updateTopScore(int score) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("Top Score");
        ref.setValue(score);
    }
}