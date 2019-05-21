package com.example.sharedpreference.CustomVeiwPager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sharedpreference.R;

public class ChildFragment extends Fragment {


    public ChildFragment() {
    }

    public static ChildFragment newInstance(DataModel dataModel, boolean isWebView) {
        ChildFragment fragment = new ChildFragment();
        Bundle args = new Bundle();
        args.putString("title", dataModel.title);
        args.putString("description", dataModel.description);
        args.putString("url", dataModel.url);
        args.putBoolean("isWebView", isWebView);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_child, container, false);
        RelativeLayout rl = rootView.findViewById(R.id.rl);
        WebView webView = rootView.findViewById(R.id.webView);
        TextView txtTitle = rootView.findViewById(R.id.txtTitle);
        Button button = rootView.findViewById(R.id.button);
        TextView txtDescription = rootView.findViewById(R.id.txtDescription);

        boolean isWebView = getArguments().getBoolean("isWebView");
        if (isWebView) {
            webView.setVisibility(View.VISIBLE);
            rl.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
            txtDescription.setVisibility(View.GONE);

            webView.loadUrl(getArguments().getString("url"));

        } else {
            webView.setVisibility(View.GONE);
            rl.setVisibility(View.VISIBLE);
            txtDescription.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);

            txtTitle.setText(getArguments().getString("title"));
            txtDescription.setText(getArguments().getString("description"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParentFragment parentFrag = ((ParentFragment) ChildFragment.this.getParentFragment());
                parentFrag.nestedViewPager.setCurrentItem(1);
            }
        });


        return rootView;
    }
}
