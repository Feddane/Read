package com.example.cs50project;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterVh> implements Filterable {


    public List<UserModel> userModelList = new ArrayList<>();
    public List<UserModel> getUserModelListFilter = new ArrayList<>();
    public Context context;
    public UserClickListener userClickListener;

    public UserAdapter(List<UserModel> userModels, Context context, UserClickListener userClickListener){
        this.userModelList = userModels;
        this.getUserModelListFilter = userModels;
        this.context = context;
        this.userClickListener = userClickListener;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.values = getUserModelListFilter;
                    filterResults.count = getUserModelListFilter.size();
                }else{
                    String searchStr = constraint.toString().toLowerCase();
                    List<UserModel> userModels = new ArrayList<>();
                    for(UserModel userModel: getUserModelListFilter){
                        if(userModel.getCategory().toLowerCase().contains(searchStr)){
                            userModels.add(userModel);
                        }
                    }

                    filterResults.values = userModels;
                    filterResults.count = userModels.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                userModelList = (List<UserModel>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }


    public interface UserClickListener{
        void selectedUser(UserModel userModel);
    }




    @NonNull
    @Override
    public UserAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_users,parent,false);
        return new UserAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserAdapterVh holder, int position) {

        UserModel userModel = userModelList.get(position);
        String title = userModel.getTitle();
        String author = userModel.getAuthor();
        String prefix = String.valueOf(title.charAt(0));
        String category = userModel.getCategory();


        holder.cardView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.recyclerview_animation));

        holder.author.setText(author);
        holder.title.setText(title);
        holder.image.setImageResource(userModel.getImage());
        holder.category.setText(category);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userClickListener.selectedUser(userModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class UserAdapterVh extends RecyclerView.ViewHolder {

        CardView cardView;
        private TextView title;
        private TextView author;
        private ImageView image;
        private TextView category;


        public UserAdapterVh(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.img);
            category = itemView.findViewById(R.id.category);

        }
    }


}

