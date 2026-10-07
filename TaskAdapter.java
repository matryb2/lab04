package com.example.lab04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.lab04.Task;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {
    private List<Task> listaZadan;

    public TaskAdapter(List<Task> listaZadan) {
        this.listaZadan = listaZadan;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = listaZadan.get(position);

        holder.textViewTitle.setText(task.getTitle());
        holder.textViewCategory.setText(task.getCategory());

    }

    @Override
    public int getItemCount() {
        return listaZadan.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewCategory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textView);
            textViewCategory = itemView.findViewById(R.id.textView2);
        }
    }
}