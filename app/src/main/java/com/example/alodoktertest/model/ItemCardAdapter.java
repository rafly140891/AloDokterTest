package com.example.alodoktertest.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alodoktertest.R;

public class ItemCardAdapter extends RecyclerView.Adapter<ItemCardAdapter.ItemCardViewHolder> {

    private ItemCards[] dataList;

    private View.OnClickListener onItemClickListener;

    public ItemCardAdapter(ItemCards[] dataList) {
        this.dataList = dataList;
    }

    @Override
    public ItemCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_item, parent, false);
        return new ItemCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemCardViewHolder holder, int position) {
        final  ItemCards itemCards = dataList[position];

        holder.typeImage.setText(dataList[position].getTypeImage());
        holder.titleImage.setText(dataList[position].getTitleImage());
        holder.imageSource.setBackgroundResource(dataList[position].getImageSource());
    }

    @Override
    public int getItemCount() {
        return dataList.length;
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        onItemClickListener = itemClickListener;
    }

    public class ItemCardViewHolder extends RecyclerView.ViewHolder {

        private TextView titleImage, typeImage;
        private CardView imageSource;

        public ItemCardViewHolder(View itemView) {
            super(itemView);

            this.typeImage = itemView.findViewById(R.id.txtView_type_items);
            this.titleImage = itemView.findViewById(R.id.txtView_title_items);
            this.imageSource = itemView.findViewById(R.id.cardView_items);

            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);
        }
    }
}
