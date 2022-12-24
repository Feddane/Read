package com.example.cs50project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements UserAdapter.UserClickListener{


    RecyclerView rvUsers;
    UserAdapter userAdapter;
    List<UserModel> userModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvUsers = findViewById(R.id.rvUsers);
        setData();
        prepareRecyclerView();
    }

    public void setData() {
        userModelList.add(new UserModel(R.drawable.itendwithus,"It ends with us", "Colleen Hoover", "Category: romance"));
        userModelList.add(new UserModel(R.drawable.book2,"The seven husbands of eleven evelyn hugo", "Taylor Jenkins Reid", "Category: historical fiction"));
        userModelList.add(new UserModel(R.drawable.book3,"A court of thorns and roses series", "Sarah J. Maas", "Category: fantasy"));
        userModelList.add(new UserModel(R.drawable.book4,"The great alone", "Kristin Hannah", "Category: historical fiction"));
        userModelList.add(new UserModel(R.drawable.book5,"Verity", "Colleen Hoover", "Category: thriller"));
        userModelList.add(new UserModel(R.drawable.book6,"Malibu raising", "Jennifer Longo", "Category: historical fiction"));
        userModelList.add(new UserModel(R.drawable.book7,"The invisible life of addie laRue", "V.E. Schwab", "Category: fantasy"));
        userModelList.add(new UserModel(R.drawable.book8,"Carrie soto is back", "Lolita Hernandez", "Category: historical fiction"));
        userModelList.add(new UserModel(R.drawable.book9,"Rock, paper, scissors", "Layne Fargo", "Category: thriller"));
        userModelList.add(new UserModel(R.drawable.book10,"Crescent city series", "Sarah J. Maas", "Category: fantasy"));
        userModelList.add(new UserModel(R.drawable.book11,"One true loves", "Taylor Jenkins Reid", "Category: romance"));
        userModelList.add(new UserModel(R.drawable.book12,"The silent patient", "Alex Michaelides", "Category: thriller"));
        userModelList.add(new UserModel(R.drawable.book13,"We are Brennans", "Carlene Bauer", "Category: fiction"));
        userModelList.add(new UserModel(R.drawable.book14,"The inheritance games series", "Jennifer Lynn Barnes", "Category: fiction"));
        userModelList.add(new UserModel(R.drawable.book15,"Daisy Jones and the six", "Taylor Jenkins Reid", "Category: historical fiction"));
        userModelList.add(new UserModel(R.drawable.book16,"The prisoner", "B.A Paris", "Category: thriller"));
        userModelList.add(new UserModel(R.drawable.book18,"Luckiest girl", "Jessica Koll", "Category: thriller"));
    }




    public void prepareRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUsers.setLayoutManager(linearLayoutManager);
        preAdapter();
    }

    public void preAdapter() {
        userAdapter = new UserAdapter(userModelList, this, this::selectedUser);
        rvUsers.setAdapter(userAdapter);
    }

    @Override
    public void selectedUser(UserModel userModel) {

//        Toast.makeText(this,"Selected user "+userModel.getFirstName(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, SelectedUserActivity.class).putExtra("data", userModel));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.searchView){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String searchStr = newText;
                userAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}
