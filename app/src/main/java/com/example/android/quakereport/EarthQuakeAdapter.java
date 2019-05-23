package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = " of ";


    /**Create a custom constructor which does not mirror a super class
     * The context is used to inflate the layout file, and the list is the data we want
     *  to populate into the lists.
     * @param context is used to inflate the layout file
     * @param earthQuakes is a list of EarthQuake objects to display in a list of items*/

    public EarthQuakeAdapter(Context context, List<EarthQuake> earthQuakes) {
        super(context, 0, earthQuakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //First check if the existing view is being used otherwise inflate a view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link EarthQuake} object located at this position in the list
        final EarthQuake currentEarthQuake = getItem(position);

        //Find the TextView in the list_item.xml Layout file and set the view
        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude);
        String formatMagnitude = formatMagnitude(currentEarthQuake.getmMagnitude());
        magnitudeTextView.setText(formatMagnitude);



        //Get the Location value
        String originalLocation = currentEarthQuake.getmLocation();
        String primaryLocation;
        String locationOffset;
        //Check if originalLocation contains the LOCATION_SEPERATOR before seperating
        if (originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        //Find the TextView in the list_item.xml file with the ID  offset_location and set the view
        TextView offSetLocationTextView = listItemView.findViewById(R.id.offset_location);
        offSetLocationTextView.setText(locationOffset);
        //FInd the TextView in the list_item.xml layout file with ID primary_location and set the View
        TextView pryLocationTextView = listItemView.findViewById(R.id.primary_location);
        pryLocationTextView.setText(primaryLocation);

        //Ceate a new dateObject from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthQuake.getmTimeInMilliseconds());

        //Find the TextView in the list_item.xml layout file with ID text_date and set the View
        TextView dateTextView = listItemView.findViewById(R.id.date);
        //Format the date (i.e May 16, 1999)
        String formattedDate = formatDate(dateObject);
        //Set the view
        dateTextView.setText(formattedDate);


        // Find the TextView in the list_item.xml layout file with ID time and set the View
        TextView timeTextView = listItemView.findViewById(R.id.time);
        //Format the Time (i.e 01:16:05)
        String formattedTime = formatTime(dateObject);
        //Set the view
        timeTextView.setText(formattedTime);


        //Set the background color on the magnitude circle
        //Fetch the background from the textView, which is a GradientDrawable
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);




        return listItemView;
    }



    private String formatTime(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy", Locale.ENGLISH);
        return dateFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1: magnitudeColorResourceId = R.color.magnitude1;
            break;
            case 2: magnitudeColorResourceId = R.color.magnitude2;
            break;
            case 3: magnitudeColorResourceId = R.color.magnitude3;
            break;
            case 4: magnitudeColorResourceId = R.color.magnitude4;
            break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6: magnitudeColorResourceId = R.color.magnitude6;
            break;
            case 7: magnitudeColorResourceId = R.color.magnitude7;
            break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:magnitudeColorResourceId = R.color.magnitude9;
            break;
            default:magnitudeColorResourceId = R.color.magnitude10plus;
            break;
        }
         return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
