package io.getstrike.strike;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Sidharth on 10/02/16.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {
    protected TextView name,timestamp,desc;
    protected LinearLayout layout;
    public CustomViewHolder(View view) {
        super(view);
        this.layout = (LinearLayout) view.findViewById(R.id.ll);
        this.name = (TextView) view.findViewById(R.id.text);
        this.timestamp = (TextView) view.findViewById(R.id.timestamp);
        this.desc = (TextView) view.findViewById(R.id.desc);
    }
}