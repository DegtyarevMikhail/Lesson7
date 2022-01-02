package ru.gb.lesson7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private TextView userName;

    private String message;

    public static final String MESSAGE = "MESSAGE";

    public static SecondFragment getInstance(String message)
    {
       SecondFragment fragment = new SecondFragment();

       Bundle args = new Bundle();
       args.putString(MESSAGE, message);
       fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        userName = view.findViewById(R.id.second_fragment_name);

        Bundle args = getArguments();
        if(args != null && args.containsKey(MESSAGE))
        {
            userName.setText(args.getString(MESSAGE, ""));
        }

        userName.setText(message);
    }
}
