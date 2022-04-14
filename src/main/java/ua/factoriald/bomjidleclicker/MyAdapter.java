package ua.factoriald.bomjidleclicker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {

    MainActivity ma;
    LayoutInflater lInflater;
    private LayoutInflater inflater;
    public MyAdapter( MainActivity ma, Context context,  int resource) {
//        super(context, data, resource, from, to);
        this.ma = ma;
        lInflater = (LayoutInflater) ma.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("MyAdapter.getView", "in");

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.bomj_item, parent, false);
        }
//        if (inflater == null)
//            inflater = (LayoutInflater) ma.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        if (convertView == null)
//            convertView = inflater.inflate(R.layout.bomj_item, null);

        ma.bomji[position].setBuyButton(R.id.list_buy);
        ma.bomji[position].setMultiplierButton(R.id.list_multiplier);
        ma.bomji[position].setCritView(R.id.list_crit);
//        Button Button1= (Button)convertView.findViewById(R.id.list_buy);
//
//        Button1.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                // Your code that you want to execute on this button click
//            }
//
//        });
        return convertView;
        //return super.getView(position, convertView, parent);
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public int getCount() {
        return ma.bomji.length;
    }

    @Override
    public BomjType getItem(int position) {
        return ma.bomji[position];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
