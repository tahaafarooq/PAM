package com.tahaafarooq.pam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HostRVAdapter extends RecyclerView.Adapter<HostRVAdapter.ViewHolder> {
    private ArrayList<PasswordModal> passwordModalArrayList;
    private Context context;

    public HostRVAdapter(ArrayList<PasswordModal> passwordModalArrayList, Context context) {
        this.passwordModalArrayList = passwordModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HostRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.host_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HostRVAdapter.ViewHolder holder, int position) {
        PasswordModal modal = passwordModalArrayList.get(position);
        holder.usernameTV.setText(modal.getUsername());
        holder.passwordTV.setText(modal.getPassword());
        holder.hostTV.setText(modal.getHost());
    }

    @Override
    public int getItemCount() {
        return passwordModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView usernameTV, passwordTV, hostTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTV = itemView.findViewById(R.id.usernameId);
            passwordTV = itemView.findViewById(R.id.passwordId);
            hostTV = itemView.findViewById(R.id.hostId);
        }
    }
}
