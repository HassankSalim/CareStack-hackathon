package hassan.docappoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.recyclerview.R.attr.layoutManager;


public class DocAppointActivity extends AppCompatActivity {


    // recyclerVew initaiation
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    // Buttons
    Button docApp, schedule, appointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_appoint);

//        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        // use this setting to
//        // improve performance if you know that changes
//        // in content do not change the layout size
//        // of the RecyclerView
//        recyclerView.setHasFixedSize(true);
//        // use a linear layout manager
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter
//        mAdapter = new DocDetailsAdapter(input);
//        recyclerView.setAdapter(mAdapter);

        docApp = (Button) findViewById(R.id.doc_app);
        schedule = (Button) findViewById(R.id.sch);
        appointments = (Button) findViewById(R.id.appointment);

        docApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DocAppointActivity.this, ViewDocApp.class);
                startActivity(i);
            }
        });


        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DocAppointActivity.this, BookActivity.class);
                startActivity(i);
            }
        });

        appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DocAppointActivity.this, DocAppoinment.class);
                startActivity(i);
            }
        });

    }

}
