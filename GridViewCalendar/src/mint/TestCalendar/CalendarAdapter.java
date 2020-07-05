package mint.TestCalendar;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CalendarAdapter extends BaseAdapter
{
	ArrayList<CalendarItem>mItem = new ArrayList<CalendarItem>();
	LayoutInflater mInflater;
	Context mContext;
	
	CalendarAdapter(Context context)
	{
		mInflater = LayoutInflater.from(context);
		mContext = context;
	}
	
	public void add(CalendarItem item)
	{
		mItem.add(item);
	}
	
	public void clear()
	{
		mItem.clear();
	}
	
	@Override
	public int getCount()
	{
		return mItem.size();
	}
	
	@Override
	public Object getItem(int position)
	{
		return null;
	}
	
	@Override
	public long getItemId(int position)
	{
		Long id = Long.parseLong(mItem.get(position).day());
		return id;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View v;
		if (convertView == null)
		{
			v = mInflater.inflate(R.layout.view_calendar, null);
		}
		else
		{
			v = convertView;
		}
		
		TextView day = (TextView)v.findViewById(R.id.day);
		day.setText(mItem.get(position).day());
		
		int yoil = mItem.get(position).yoil();
		if (yoil == 1)
			day.setTextColor(mContext.getResources().getColor(R.color.red));
		else if (yoil == 7)
			day.setTextColor(mContext.getResources().getColor(R.color.blue));
		
		day.setVisibility(View.VISIBLE);
		
		TextView take = (TextView)v.findViewById(R.id.take);
		if (mItem.get(position).isTake())
			take.setVisibility(View.VISIBLE);
		
		return v;
	}
	
}
