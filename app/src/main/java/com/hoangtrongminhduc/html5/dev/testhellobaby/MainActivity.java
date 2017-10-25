package com.hoangtrongminhduc.html5.dev.testhellobaby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hoangtrongminhduc.html5.dev.testhellobaby.VideoYoutube.Category;
import com.hoangtrongminhduc.html5.dev.testhellobaby.VideoYoutube.RecycleAdapter;
import com.hoangtrongminhduc.html5.dev.testhellobaby.VideoYoutube.Video;

import java.util.ArrayList;
import java.util.List;

import static com.hoangtrongminhduc.html5.dev.testhellobaby.R.id.recyclerView1;
import static com.hoangtrongminhduc.html5.dev.testhellobaby.R.id.recyclerView2;
import static com.hoangtrongminhduc.html5.dev.testhellobaby.R.id.recyclerView3;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private RecyclerView mRecyclerView1, mRecyclerView2, mRecyclerView3;
    private RecycleAdapter mAdapter1, mAdapter2, mAdapter3;
    private List<Video> videos1, videos2, videos3;
    private List<Category> mCategory;
    public static final String ID="id";
    public static final String TITLE="title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView1 = (RecyclerView) findViewById(recyclerView1);
        mRecyclerView2 = (RecyclerView) findViewById(recyclerView2);
        mRecyclerView3 = (RecyclerView) findViewById(recyclerView3);

        videos1 = new ArrayList<>();
        videos2 = new ArrayList<>();
        videos3 = new ArrayList<>();
        mCategory = new ArrayList<>();

        mAdapter1 = new RecycleAdapter(videos1, MainActivity.this);
        mAdapter2 = new RecycleAdapter(videos2, MainActivity.this);
        mAdapter3 = new RecycleAdapter(videos3, MainActivity.this);

        LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager mLayoutManager3 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        mRecyclerView1.setLayoutManager(mLayoutManager1);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        mRecyclerView3.setLayoutManager(mLayoutManager3);

        mRecyclerView1.setHasFixedSize(true);
        mRecyclerView1.setAdapter(mAdapter1);

        mRecyclerView2.setHasFixedSize(true);
        mRecyclerView2.setAdapter(mAdapter2);

        mRecyclerView3.setHasFixedSize(true);
        mRecyclerView3.setAdapter(mAdapter3);






        mDatabase =  FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Category").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String id = dataSnapshot.getKey().toString();
                String name = dataSnapshot.getValue().toString();
                Category category = new Category(name, id);
                mCategory.add(category);
                //Toast.makeText(MainActivity.this, category.getNameCategory() +": " + category.getIdCategory(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, mCategory.size() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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

//        for(int index = 0; index < mCategory.size(); index++){
//            Toast.makeText(this, mCategory.get(index).toString(), Toast.LENGTH_SHORT).show();
//        }
        mDatabase.child("hoathinh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Video video = dataSnapshot.getValue(Video.class);
                videos1.add(video);
                mAdapter1.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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
        mDatabase.child("amnhac").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Video video = dataSnapshot.getValue(Video.class);
                videos2.add(video);
                mAdapter2.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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
        mDatabase.child("giaoduc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Video video = dataSnapshot.getValue(Video.class);
                videos3.add(video);
                mAdapter3.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

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
}
