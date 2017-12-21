package com.alex.morgan.bearlist.list;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.morgan.bearlist.Bear;
import com.alex.morgan.bearlist.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;

class BearAdapter extends RecyclerView.Adapter<BearAdapter.BearViewHolder> {

    class BearViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;

        BearViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.profile_image);
        }
    }


    private final ArrayList<Bear> bearList;

    BearAdapter() {
        this.setHasStableIds(true);
        this.bearList = new ArrayList<>();
    }

    void setBears(Collection<Bear> bears) {
        this.bearList.clear();
        this.bearList.addAll(bears);
        this.notifyDataSetChanged();
    }

    @Override
    public BearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BearViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bear_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BearViewHolder holder, int position) {
        Bear bear = bearList.get(position);

        holder.name.setText(bear.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
        Picasso pablo = new Picasso.Builder(holder.itemView.getContext())
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.e("PICASSO", "Image failed", exception);
                    }
                })
                .build();

        pablo.load(bear.getProfileImageUrl())
                .error(android.R.drawable.ic_dialog_alert)
                .placeholder(R.drawable.grey_bear)
                .resize(200, 200)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return bearList.size();
    }

    @Override
    public long getItemId(int position) {
        return bearList.get(position).hashCode();
    }
}
