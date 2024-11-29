package com.example.electricitybill.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.electricitybill.R;

public class AboutUsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);

        // GitHub Button Click Listener
        view.findViewById(R.id.github_button).setOnClickListener(v -> openGitHub());

        return view;
    }

    // Method to open GitHub page
    private void openGitHub() {
        // Replace with your actual GitHub repository URL
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mathhforlife"));
        startActivity(browserIntent);
    }
}
