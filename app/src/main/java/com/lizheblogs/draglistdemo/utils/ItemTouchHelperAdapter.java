package com.lizheblogs.draglistdemo.utils;

/**
 * Created by Android on 12.22.2018.
 */
public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
