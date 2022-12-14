package com.example.dbr21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private List<Timetable> timetables;

    public TimetableAdapter(Context context, List<Timetable> timetables) {
        this.timetables = timetables;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    public void setData(List<Timetable> timetables){
        this.timetables = timetables;
        //notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Timetable timetable = timetables.get(position);
        holder.nameView.setText(timetable.getName());
        holder.cabinetView.setText(timetable.getCabinet());
        holder.idView.setText(timetable.getId());

    }

    @Override
    public int getItemCount() {
        return timetables.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView nameView, cabinetView, idView;
        public ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.name);
            cabinetView = view.findViewById(R.id.number);
            idView = view.findViewById(R.id.id);

        }
    }
}
