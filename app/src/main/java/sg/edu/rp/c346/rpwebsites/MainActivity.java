package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvCategory, tvSubCat;
    Spinner spCat, spSubCat;
    Button btnSubmit;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCategory = findViewById(R.id.textViewCat);
        tvSubCat = findViewById(R.id.textViewSubCat);
        spCat = findViewById(R.id.spinnerCategory);
        spSubCat = findViewById(R.id.spinnerSubCat);
        btnSubmit = findViewById(R.id.buttonSubmit);


        // Initialise the ArrayList
        alCategory = new ArrayList<>();
        // Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);
        // Bind the ArrayAdapter to the Spinner
        spSubCat.setAdapter(aaCategory);

        spCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alCategory.clear();

                switch (position) {
                    case 0:
                        String[] strNumbers = getResources().getStringArray(R.array.rp_subcategory);
                        alCategory.addAll(Arrays.asList(strNumbers));
                        spSubCat.setAdapter(aaCategory);
                        break;

                    case 1:
                        String[] strNumbers1 = getResources().getStringArray(R.array.soi_subcategory);
                        alCategory.addAll(Arrays.asList(strNumbers1));
                        spSubCat.setAdapter(aaCategory);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int catpos = spCat.getSelectedItemPosition();
                int subpos = spCat.getSelectedItemPosition();
                alCategory.clear();

                if(catpos == 0 && subpos == 0) {
                    url = "https://www.rp.edu.sg/";
                }
                else if (catpos == 0 && subpos == 1) {
                    url = "https://www.rp.edu.sg/student-life";
                }
                else if (catpos == 1 && subpos == 0) {
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                }
                else if (catpos == 1 && subpos == 1) {
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                }


                Intent intentsite = new Intent (getBaseContext(), Website.class);
                intentsite.putExtra("Website", url);
                startActivity(intentsite);
            }
        });



    }
}

