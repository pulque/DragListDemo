package com.lizheblogs.draglistdemo.utils;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.lizheblogs.draglistdemo.base.BaseAdapter;

public class TouchGirdHelperCallback extends ItemTouchHelper.Callback {

    private final BaseAdapter mAdapter;

    public TouchGirdHelperCallback(BaseAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.DOWN
                | ItemTouchHelper.UP | ItemTouchHelper.RIGHT;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.DOWN
                | ItemTouchHelper.UP | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

}
