package com.lizheblogs.draglistdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lizheblogs.draglistdemo.BR;
import com.lizheblogs.draglistdemo.R;
import com.lizheblogs.draglistdemo.base.BaseAdapter;
import com.lizheblogs.draglistdemo.bean.Item;
import com.lizheblogs.draglistdemo.databinding.DragListFragmentBinding;
import com.lizheblogs.draglistdemo.utils.TouchHelperCallback;

import java.util.ArrayList;


/**
 * Created by LiZhe on 2018-11-19.
 */
public class DragListFragment extends Fragment {

    private DragListFragmentBinding binding;

    public static DragListFragment newInstance() {
        return new DragListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DragListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Item item = new Item();
            item.setText("这是第" + (i + 1) + "行！");
            items.add(item);
        }

        BaseAdapter<Item> adapter = new BaseAdapter<>(R.layout.list_item, BR.listItem, items);

        binding.functionsList.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new TouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(binding.functionsList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
