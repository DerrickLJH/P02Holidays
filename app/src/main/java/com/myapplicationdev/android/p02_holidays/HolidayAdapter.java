package com.myapplicationdev.android.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivHoliday;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName =         rowView.findViewById(R.id.tvHolidayName);
        tvDate = rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivHoliday =             rowView.findViewById(R.id.ivHoliday);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holiday.get(position);
        // Set the TextView to show the food

        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        // Set the image to star or nostar accordingly
        if(currentHoliday.getImage() == "newyear") {
            ivHoliday.setImageResource(R.drawable.newyear);
        }
        else if(currentHoliday.getImage() == "labourday") {
            ivHoliday.setImageResource(R.drawable.labourday);
        }
        else if(currentHoliday.getImage() == "cny") {
            ivHoliday.setImageResource(R.drawable.cny);
        }
        else{
            ivHoliday.setImageResource(R.drawable.good_friday);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }




}
