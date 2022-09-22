package com.example.medicine_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;


public class FragmentSearch extends Fragment {

    private AutoCompleteTextView txAutoComplete;
    private ArrayList<String> DrugList;
    private AutoComplete autoDB;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        txAutoComplete = view.findViewById(R.id.txAutoComplete);
        autoDB = new AutoComplete(getActivity());

        DrugList = autoDB.getName();

        ArrayAdapter<String> autoComplete = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, DrugList);
        txAutoComplete.setAdapter(autoComplete); //layout id:txAutoComplete에 어댑터 autoComplete 연결
        return view;
    }
}