package com.ppb.salsa.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.ppb.salsa.database.DatabaseModel;
import com.ppb.salsa.utils.FunctionHelper;
import com.ppb.salsa.R;
import com.ppb.salsa.utils.FunctionLogo;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    List<DatabaseModel> modelDatabase;
    Context mContext;

    public HistoryAdapter(Context context, List<DatabaseModel> modelInputList) {
        this.mContext = context;
        this.modelDatabase = modelInputList;
    }


    public void setDataAdapter(List<DatabaseModel> items) {
        modelDatabase.clear();
        modelDatabase.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_riwayat, parent, false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        final DatabaseModel data = modelDatabase.get(position);

        holder.tvNama.setText(data.getNama_menu());
        holder.ivLogo.setImageResource(FunctionLogo.getCategoriesLogo(data.getNama_menu()));
        holder.tvDate.setText(data.getOrderDate());
        holder.tvJml.setText(data.getItems() + " item");
        holder.tvPrice.setText(FunctionHelper.rupiahFormat(data.getHarga()));
        holder.btnCode.setText(data.getOrderCode());
    }

    @Override
    public int getItemCount() {
        return modelDatabase.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNama, tvDate, tvJml, tvPrice, btnCode;
        public ImageView ivLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvJml = itemView.findViewById(R.id.tvJml);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivLogo = itemView.findViewById(R.id.imgLogoHistory);
            btnCode = itemView.findViewById(R.id.btnCode);
        }
    }

    public void setSwipeRemove(int position) {
        modelDatabase.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(DatabaseModel databaseModel, int position) {
        modelDatabase.add(position, databaseModel);
        notifyItemInserted(position);
    }

    public List<DatabaseModel> getData() {
        return modelDatabase;
    }

}