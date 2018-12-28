package com.lizheblogs.draglistdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lizheblogs.draglistdemo.databinding.CodeFragmentBinding;


/**
 * Created by LiZhe on 2018-11-19.
 */
public class CodeFragment extends Fragment {

    private CodeFragmentBinding binding;

    public static CodeFragment newInstance() {
        return new CodeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CodeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.textView.setText(text);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private final String text = "package com.lizheblogs.draglistdemo.utils;\n" +
            "\n" +
            "import android.support.v7.widget.RecyclerView;\n" +
            "import android.support.v7.widget.helper.ItemTouchHelper;\n" +
            "\n" +
            "import com.lizheblogs.draglistdemo.base.BaseAdapter;\n" +
            "\n" +
            "public class TouchHelperCallback extends ItemTouchHelper.Callback {\n" +
            "\n" +
            "    private final BaseAdapter mAdapter;\n" +
            "\n" +
            "    public TouchHelperCallback(BaseAdapter adapter) {\n" +
            "        mAdapter = adapter;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public boolean isLongPressDragEnabled() {\n" +
            "        return true;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public boolean isItemViewSwipeEnabled() {\n" +
            "        return true;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {\n" +
            "        int dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.DOWN\n" +
            "                | ItemTouchHelper.UP | ItemTouchHelper.RIGHT;\n" +
            "        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;\n" +
            "        return makeMovementFlags(dragFlags, swipeFlags);\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,\n" +
            "                          RecyclerView.ViewHolder target) {\n" +
            "        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());\n" +
            "        return true;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {\n" +
            "        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());\n" +
            "    }\n" +
            "\n" +
            "}\n";
}
