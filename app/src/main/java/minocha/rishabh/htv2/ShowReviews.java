package minocha.rishabh.htv2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishabh on 24/02/18.
 */

public class ShowReviews extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    private DatabaseReference databaseReference;
    private List<ReviewApplication> allTask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_reviews);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        allTask = new ArrayList<ReviewApplication>();


        databaseReference = FirebaseDatabase.getInstance().getReference("Reviews");
        recyclerView = (RecyclerView)findViewById(R.id.task_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    private void getAllTask(DataSnapshot dataSnapshot){
        //for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
        ReviewApplication stuff = dataSnapshot.getValue(ReviewApplication.class);
        allTask.add(stuff);

        // String taskTitle = singleSnapshot.getValue(String.class);
        // String other = singleSnapshot.getValue(String.class);
        // allTask.add(new StuffInCard(taskTitle));
        //  }

        recyclerViewAdapter = new RecyclerViewAdapter(ShowReviews.this, allTask);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
