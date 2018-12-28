package com.lizheblogs.draglistdemo.base;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lizheblogs.draglistdemo.utils.ItemTouchHelperAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by LiZhe on 2018-10-31.
 * com.lizheblogs.databinding.ui.list
 */
public class BaseAdapter<T> extends RecyclerView.Adapter<BaseHolder> implements ItemTouchHelperAdapter {

    private List<T> listData;
    private View.OnClickListener listener;
    private int layoutId;
    private int variableId;


    public BaseAdapter(int layoutId, int variableId, List<T> listData) {
        this.listData = listData;
        this.variableId = variableId;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseHolder(LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseHolder holder, int position) {
        T item = listData.get(position);
        holder.itemView.setOnClickListener(listener);
        holder.itemView.setTag(item);
        holder.setBinding(variableId, item);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource) {
        if (resource != 0) {
            imageView.setImageResource(resource);
        }
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(listData, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(listData, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        listData.remove(position);
        notifyItemRemoved(position);
    }
}

