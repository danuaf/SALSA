package com.ppb.salsa.main;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.ppb.salsa.R;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.ViewHolder>{

    List<ModelDiscount> modelDiscountList;
    Context ctx;

    public DiscountAdapter(Context context, List<ModelDiscount> items) {
        this.ctx = context;
        this.modelDiscountList = items;
    }

    @Override
    public DiscountAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_discount, parent, false);
        return new DiscountAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DiscountAdapter.ViewHolder holder, int position) {
        final ModelDiscount data = modelDiscountList.get(position);
        holder.imageProduct.setImageResource(data.getimageProduct());
        holder.tvPlaceName.setText(data.getTvPlaceName());
        holder.tvDicountPrice.setText(data.getTvDiscountPrice());
        holder.imageDiscountLogo.setImageResource(data.getImageDiscountLogo());
        holder.tvOriginalPrice.setText(data.getTvOriginaltPrice());
    }

    @Override
    public int getItemCount() {
        return modelDiscountList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPlaceName, tvDicountPrice, tvOriginalPrice;
        public ImageView imageProduct, imageDiscountLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPlaceName = itemView.findViewById(R.id.tvPlaceName);
            tvDicountPrice = itemView.findViewById(R.id.tvDiscountPrice);
            imageProduct = itemView.findViewById(R.id.imgProductDiscount);
            imageDiscountLogo = itemView.findViewById(R.id.imgDiscountLogo);
            tvOriginalPrice = itemView.findViewById(R.id.tvOriginalPrice);
            tvOriginalPrice.setPaintFlags(tvOriginalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

}
