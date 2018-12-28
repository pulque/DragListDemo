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
import com.lizheblogs.draglistdemo.databinding.DragGridFragmentBinding;
import com.lizheblogs.draglistdemo.utils.TouchGirdHelperCallback;

import java.util.ArrayList;


/**
 * Created by LiZhe on 2018-11-19.
 */
public class DragGridFragment extends Fragment {

    private DragGridFragmentBinding binding;

    public static DragGridFragment newInstance() {
        return new DragGridFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DragGridFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Item item = new Item();
            item.setText("第" + (i + 1) + "行！");
            items.add(item);
        }

        BaseAdapter<Item> adapter = new BaseAdapter<>(R.layout.grid_item, BR.gridItem, items);
        binding.functionsList.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new TouchGirdHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(binding.functionsList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
