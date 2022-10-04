package com.example.medicine_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

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

        //null값이거나 데이터 베이스에 없는 경우 동작 안하는 예외처리 해야함
        String nameT = txAutoComplete.getText().toString();

        if(nameT != null || nameT != "약 이름으로 검색하기") {
            Button searchbtn = view.findViewById(R.id.searchbtn);
            searchbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("drugName", txAutoComplete.getText().toString());
                    startActivity(intent);
                }
            });
        }
        return view;
    }
}