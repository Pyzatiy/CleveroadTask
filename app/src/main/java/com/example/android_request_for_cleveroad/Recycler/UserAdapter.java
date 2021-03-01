package com.example.android_request_for_cleveroad.Recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_request_for_cleveroad.ImageLoader;
import com.example.android_request_for_cleveroad.R;
import com.example.android_request_for_cleveroad.objects.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final Context context;
    private List<User> users = new ArrayList<>();

    public void setUsers(List<User> users) {
        this.users = users;
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
        User user = users.get(position);
        ImageLoader.imgLoad(context,user.getPicture().getThumbnail(),holder.img_user_view);
        holder.general_tv.setText(R.string.name_string);
        holder.info_tv.setText(String.format("%s%s%s", user.getName().getTitle(), user.getName().getFirst(), user.getName().getLast()));

    }

    @Override
    public int getItemCount() {
        return users.size();
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
