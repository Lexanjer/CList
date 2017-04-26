package ru.example.checklist ;


import android.content.*;
import android.support.v4.app.*;
import android.view.*;

public class AbstractTabFragment extends Fragment {

    private String title;
    protected Context context;
    protected View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
