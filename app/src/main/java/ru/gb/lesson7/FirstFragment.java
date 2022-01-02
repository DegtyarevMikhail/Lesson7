package ru.gb.lesson7;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private Button fragmentButton;

    private EditText userName;

    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof Controller)
        {
            this.controller = (Controller) context;
        }
        else {
            throw new IllegalStateException("Activity must implement Controller");
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = container.getContext();
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fragmentButton = view.findViewById(R.id.first_fragment_button);
        fragmentButton.setOnClickListener(this);

        userName = view.findViewById(R.id.first_fragment_text);
    }

    interface Controller {
        void startButtonPressed(String message);
    }
    private Controller controller;

    @Override
    public void onClick(View view) {
        // getContext() контекст

        // getActivity() активность запустившая фрагмент

        //requireActivity()

       controller.startButtonPressed(
               userName.getText().toString()
       );
    }
}
