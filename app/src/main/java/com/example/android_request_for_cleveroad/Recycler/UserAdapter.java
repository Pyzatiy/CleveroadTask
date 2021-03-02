package com.example.android_request_for_cleveroad.Recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_request_for_cleveroad.utils.ImageLoader;
import com.example.android_request_for_cleveroad.R;
import com.example.android_request_for_cleveroad.objects.SimpleUser;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final Context context;
    private List<SimpleUser> simpleUsers = new ArrayList<>();

    public void setUsers(List<SimpleUser> users) {
        this.simpleUsers = users;
        notifyDataSetChanged();
    }

    public UserAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleUser simpleUser = simpleUsers.get(position);
        ImageLoader.imgLoad(context,simpleUser.getPicture(),holder.img_user_view);
        holder.general_tv.setText(R.string.name_string);
        holder.info_tv.setText(simpleUser.getFullName());

    }

    @Override
    public int getItemCount() {
        return simpleUsers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView img_user_view;
        final TextView general_tv, info_tv;

        public ViewHolder(@NonNull View view) {
            super(view);
            img_user_view = view.findViewById(R.id.img_user_view);
            general_tv = view.findViewById(R.id.general_tv);
            info_tv = view.findViewById(R.id.info_tv);

        }
    }
}
