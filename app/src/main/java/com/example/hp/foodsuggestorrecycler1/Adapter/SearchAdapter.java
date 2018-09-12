package com.example.hp.foodsuggestorrecycler1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.foodsuggestorrecycler1.Model.FoodModel;
import com.example.hp.foodsuggestorrecycler1.R;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder
{

    public TextView foodName,foodIngredients,foodTaste,foodType;

    public SearchViewHolder(@NonNull View itemView)
    {
        super( itemView );
        foodName = itemView.findViewById( R.id.foodNameTv );
        foodIngredients = itemView.findViewById( R.id.foodIngredientsTv );
        foodTaste = itemView.findViewById( R.id.foodTasteTv );
        foodType = itemView.findViewById( R.id.foodTypeTv);

    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>{

    private Context context;
    private List<FoodModel> foodModels;

    public SearchAdapter(Context context, List<FoodModel>foodModels)
    {
        this.context = context;
        this.foodModels = foodModels;

    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View itemView = inflater.inflate( R.layout.layout_item, parent, false );
        return new SearchViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        holder.foodName.setText( foodModels.get( position ).getFoodName() );
        holder.foodIngredients.setText( foodModels.get( position ).getFoodIngredients() );
        holder.foodType.setText( foodModels.get( position ).getFoodType() );
        holder.foodTaste.setText( foodModels.get( position ).getFoodTaste() );


    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }
}
