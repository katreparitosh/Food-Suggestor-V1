package com.example.hp.foodsuggestorrecycler1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.hp.foodsuggestorrecycler1.Adapter.SearchAdapter;
import com.example.hp.foodsuggestorrecycler1.Database.Database;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter adapter;

    MaterialSearchBar materialSearchBar;
    List<String> suggestList = new ArrayList<>(  );

    Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //initialize the view
        recyclerView = findViewById( R.id.mt_recycler_search );
        layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true );

        materialSearchBar = findViewById( R.id.search_bar );

        //initialize database
        database = new Database( this );

        //Setup search bar
        materialSearchBar.setHint( "Search " );
        materialSearchBar.setCardViewElevation( 10 );
        loadSuggestList();
        materialSearchBar.addTextChangeListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<String> suggest = new ArrayList<>(  );
                for (String search : suggestList)
                {
                    if (search.toLowerCase().contains( materialSearchBar.getText().toLowerCase() ))
                        suggest.add( search );
                }
                materialSearchBar.setLastSuggestions( suggest );
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );
        materialSearchBar.setOnSearchActionListener( new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled)
                {
                    //if close search, just restore default
                    adapter = new SearchAdapter( getBaseContext(),database.getFoodModel() );
                    recyclerView.setAdapter( adapter );
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                startSearch( text.toString() );
            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        } );

        //initializa adpaer default set to all result
        adapter = new SearchAdapter( this, database.getFoodModel() );
        recyclerView.setAdapter( adapter );
    }

    private void startSearch(String text) {

        adapter = new SearchAdapter( this,database.getFoodByFoodName( text ) );
        recyclerView.setAdapter( adapter );
    }


    private void loadSuggestList()
    {
        suggestList = database.getFoodNames();
        materialSearchBar.setLastSuggestions( suggestList );
    }

}
