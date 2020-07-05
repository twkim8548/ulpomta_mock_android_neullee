package com.example.passion.src.MainFragment.FragmentChart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.passion.R;

import java.util.ArrayList;
import java.util.Calendar;

public class FragmentChartAdapter extends BaseAdapter {
    private final ArrayList<item_data> list;

    private final LayoutInflater inflater;

    //생성자
    public FragmentChartAdapter(Context context, ArrayList<item_data> list) {
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_fragment_chart, parent, false);//아이템
            holder = new ViewHolder();

            holder.layoutItemGridView = (LinearLayout) convertView.findViewById(R.id.layout_fragment_chart);//아이템
            holder.tvItemGridView = (TextView) convertView.findViewById(R.id.tv_fragment_chart_day);//아이템


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvItemGridView.setText(list.get(position).getDay());

        //해당 날짜 텍스트 컬러,배경 변경
        Calendar calendar = Calendar.getInstance();
        //오늘 day 가져옴
        Integer today = calendar.get(Calendar.DAY_OF_MONTH);
        String sToday = String.valueOf(today);
        if (sToday.equals(getItem(position))) { //오늘 날짜 초기 서냍
            holder.layoutItemGridView.setBackground(ContextCompat.getDrawable(convertView.getContext(),R.drawable.stroke_calender_true));
//            holder.layoutItemGridView.setSelected(true);
            holder.layoutItemGridView.setBackground(ContextCompat.getDrawable(convertView.getContext(), R.drawable.stroke_calender_true));

        }


        if (list.get(position).isChecked) {
            holder.layoutItemGridView.setBackground(ContextCompat.getDrawable(convertView.getContext(), R.drawable.stroke_calender_true));
        }
        else {
            holder.layoutItemGridView.setBackground(ContextCompat.getDrawable(convertView.getContext(), R.drawable.stroke_calender_false));

        }

        return convertView;
    }

    private class ViewHolder {
        LinearLayout layoutItemGridView;
        TextView tvItemGridView;
    }

}
