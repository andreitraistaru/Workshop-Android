package com.workshopandroid;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class RecyclerViewAdapterSecondDescendantActivity extends RecyclerView.Adapter<RecyclerViewAdapterSecondDescendantActivity.CustomViewHolder> {

    private Activity activity;

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public CustomViewHolder(View view) {
            super(view);

            button = view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // To be able to click on the element from recyclerView (inside the button)

                    Toast.makeText(view.getContext(), view.getContext().getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setText(String text) {
            button.setText(text);
        }
    }

    public RecyclerViewAdapterSecondDescendantActivity(Activity activity) {
        super();

        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterSecondDescendantActivity.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_view_holder, viewGroup, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // To be able to click on the element from recyclerView (outside the button)

                Toast.makeText(activity,activity.getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
            }
        });

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.setText(activity.getResources().getStringArray(R.array.recycler_view_items_second_descendant_activity)[i]);
    }

    @Override
    public int getItemCount() {
        return activity.getResources().getStringArray(R.array.recycler_view_items_second_descendant_activity).length;
    }
}
