package com.example.hp.foodsuggestorrecycler1.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.hp.foodsuggestorrecycler1.Model.FoodModel;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper
{
    private static final String DB_NAME = "fooddatabase.db";
    private static final int DB_VERSION = 1;

    public Database(Context context)
    {
        super( context, DB_NAME, null, DB_VERSION );
    }

    // function to get all food data
    public List<FoodModel> getFoodModel()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //all column names
        String[] sqlSelect = {"food_name","food_ingredients","food_rating","food_type","food_taste"};
        String tableName = "food_info";  //table name

        qb.setTables( tableName );
        Cursor cursor = qb.query(db, sqlSelect,null,null,null,null,null);
        List<FoodModel>result = new ArrayList<>(  );
        if (cursor.moveToFirst())
        {
            do {
                FoodModel foodModel = new FoodModel(  );
                foodModel.setFoodRating( cursor.getInt( cursor.getColumnIndex( "food_rating" ) ) );
                foodModel.setFoodName( cursor.getString( cursor.getColumnIndex( "food_name" ) ) );
                foodModel.setFoodIngredients( cursor.getString( cursor.getColumnIndex( "food_ingredients" ) ) );
                foodModel.setFoodTaste( cursor.getString( cursor.getColumnIndex( "food_taste" ) ) );
                foodModel.setFoodType( cursor.getString( cursor.getColumnIndex( "food_type" ) ) );
                result.add( foodModel  );
            }while (cursor.moveToNext());

        }
        return result;
    }


    //fucntion to get all food name
    public List<String> getFoodNames()
    {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //all column names
        String[] sqlSelect = {"food_name"};
        String tableName = "food_info";  //table name

        qb.setTables( tableName );
        Cursor cursor = qb.query(db, sqlSelect,null,null,null,null,null);
        List<String>result = new ArrayList<>(  );
        if (cursor.moveToFirst())
        {
            do{
                result.add( cursor.getString( cursor.getColumnIndex( "food_name" ) ));
            }while (cursor.moveToNext());

        }
        return result;
    }

    //function to get food by food name
    public List<FoodModel> getFoodByFoodName(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //all column names
        String[] sqlSelect = {"food_name", "food_ingredients", "food_rating", "food_type", "food_taste"};
        String tableName = "food_info";  //table name

        qb.setTables( tableName );

        //this will be like a query, Select * from foodmodel where Name LIKE %example%
        //exact name,remove the % sign and + sign,
        //Cursor cursor = qb.query(db, sqlSelect,"Food Name LIKE ?", new String[]{name}, null,null,null);

        //Cursor cursor = qb.query(db, sqlSelect," food_name LIKE ?", new String[]{"%" + name + "%"}, null,null,null);
        Cursor cursor = qb.query( db,sqlSelect,"food_name LIKE ?",new String[]{"%"+name+"%"},null,null,null );
        List<FoodModel>result = new ArrayList<>(  );
        if (cursor.moveToFirst())
        {
            do {
                FoodModel foodModel = new FoodModel(  );
                foodModel.setFoodRating( cursor.getInt( cursor.getColumnIndex( "food_rating" ) ) );
                foodModel.setFoodName( cursor.getString( cursor.getColumnIndex( "food_name" ) ) );
                foodModel.setFoodIngredients( cursor.getString( cursor.getColumnIndex( "food_ingredients" ) ) );
                foodModel.setFoodTaste( cursor.getString( cursor.getColumnIndex( "food_taste" ) ) );
                foodModel.setFoodType( cursor.getString( cursor.getColumnIndex( "food_type" ) ) );

                result.add( foodModel  );
            }while (cursor.moveToNext());

        }
        return result;
    }
}
