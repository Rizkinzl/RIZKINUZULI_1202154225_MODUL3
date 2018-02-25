package com.example.rzknzl.rizkinuzuli_1202154225_modul3;

/**
 * Created by RZKNZL on 25/02/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.MenuViewHolder> {

    private final LinkedList<String> title;
    private final LinkedList<String> subtitle;
    private final LinkedList<Integer> image;
    private LayoutInflater mInflater;
    private Context context;

    public AdapterList(Context context, LinkedList<String> title, LinkedList<String> subtitle, LinkedList<Integer> image) {
        mInflater = LayoutInflater.from(context);
        this.title = title;
        this.subtitle = subtitle;
        this.image = image;
    }

    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_list, parent, false);
        return new MenuViewHolder(mItemView, this);
    }

    public void onBindViewHolder(MenuViewHolder holder, int position) {
        String itemTitle = title.get(position);
        String itemSub = subtitle.get(position);
        int itemImage = image.get(position);

        holder.menuTitle.setText(itemTitle);
        holder.menuSub.setText(itemSub);
        holder.menuImage.setImageResource(itemImage);
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView menuTitle;
        public final TextView menuSub;
        public final ImageView menuImage;
        final AdapterList mAdapter;

        // constructor
        public MenuViewHolder(View itemView, AdapterList adapter) {
            super(itemView);

            menuTitle = itemView.findViewById(R.id.textTitle);
            menuSub = itemView.findViewById(R.id.textSub);
            menuImage = itemView.findViewById(R.id.imageLogo);

            this.mAdapter = adapter;
            context = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // mengambil posisi list item yg di klik
            int mPosition = getLayoutPosition();

            // mengambil data pada posisi tsb
            String itemTitle = title.get(mPosition);
            String itemSub = subtitle.get(mPosition);
            int itemImage = image.get(mPosition);

            // intent ke menu detail pake put extra
            Intent intent = new Intent(context, menuDetailActivity.class);
            intent.putExtra("title", itemTitle);
            intent.putExtra("subtitle", itemSub);
            intent.putExtra("image", itemImage);
            context.startActivity(intent);

            mAdapter.notifyDataSetChanged();
        }
    }
}
