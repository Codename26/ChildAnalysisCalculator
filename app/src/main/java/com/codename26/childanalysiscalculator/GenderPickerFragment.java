package com.codename26.childanalysiscalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GenderPickerFragment extends DialogFragment {

    public interface OnGenderPicked{
        void onGenderPicked(String s);
    }
    @BindView(R.id.ivBoy)
    ImageView ivBoy;
    @BindView(R.id.tvBoy)
    TextView tvBoy;
    @BindView(R.id.ivGirl)
    ImageView ivGirl;
    @BindView(R.id.tvGirl)
    TextView tvGirl;


    public GenderPickerFragment(){

    }

    public static GenderPickerFragment newInstance(String title){
        GenderPickerFragment frag = new GenderPickerFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.dialog_gender_picker, container);
               ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String title = getArguments().getString("title", getString(R.string.choose_gender));
        getDialog().setTitle(title);
    }

     @OnClick({R.id.ivBoy, R.id.tvBoy})
    public void onClickBoy() {
        OnGenderPicked listener = (OnGenderPicked) getActivity();
        listener.onGenderPicked(MainActivity.BOY);
        dismiss();
    }

    @OnClick({R.id.ivGirl, R.id.tvGirl})
    public void onClickGirl() {
        OnGenderPicked listener = (OnGenderPicked) getActivity();
        listener.onGenderPicked(MainActivity.GIRL);
        dismiss();
    }

}
