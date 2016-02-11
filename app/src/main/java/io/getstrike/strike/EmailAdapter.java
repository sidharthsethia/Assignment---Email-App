package io.getstrike.strike;

/**
 * Created by Sidharth on 10/02/16.
 */

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<Email> emailsList;
    private Context mContext;
    CoordinatorLayout coordinatorLayout;

    public EmailAdapter(Context context, List<Email> emailsList, CoordinatorLayout layout) {
        this.emailsList = emailsList;
        this.mContext = context;
        this.coordinatorLayout = layout;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        viewHolder.layout.setTag(viewHolder);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomViewHolder holder = (CustomViewHolder) view.getTag();
                int position = holder.getPosition();
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Selected: " + (position+1), Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        };

        viewHolder.layout.setOnClickListener(clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Email item = emailsList.get(i);

        //Download image using picasso library
        customViewHolder.name.setText(item.name);
        //Setting text view title

        PrettyTime p = new PrettyTime();
        Date date = new Date(item.timestamp*1000);
        String str = p.format(date);

        if(str.contains("mon") || str.contains("week")){
            DateFormat format = new SimpleDateFormat("d MMM");
            str = format.format(date);
        }

        customViewHolder.timestamp.setText(str);
        customViewHolder.desc.setText(item.desc);
    }

    @Override
    public int getItemCount() {
        return (null != emailsList ? emailsList.size() : 0);
    }
}