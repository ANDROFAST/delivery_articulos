package com.myapps.delivery;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends Fragment {
    public static final String TAG = "stats";

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C0477R.layout.fragment_seleccionar_categoria, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<String> content = new ArrayList();
        content.add("list");
        content.add("list");
        content.add("list");
        content.add("list");
        content.add("list");
        content.add("list");
        content.add("list");
        ((ListView) getActivity().findViewById(2131296397)).setAdapter(new ArrayAdapter(getActivity(), 17367043, content));
    }
}
