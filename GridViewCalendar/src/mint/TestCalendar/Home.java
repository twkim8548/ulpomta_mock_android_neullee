package mint.TestCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class Home extends Activity
{
	CalendarAdapter adt;
	GridView grid; 
	Calendar cal;
	TextView date;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); 
		
		adt = new CalendarAdapter(this);
		grid = (GridView)findViewById(R.id.grid);
		date = (TextView)findViewById(R.id.date);
		
		cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m =cal.get(Calendar.MONTH)+1;
		cal.set(y, m-1, 1);
		
		doShow();
	}
	
	private void doShow()
	{
		adt.clear();
		int y = cal.get(Calendar.YEAR);
		int m =cal.get(Calendar.MONTH)+1;
		date.setText(y+"-"+m);
		
		// 1일의 요일
		int sYoil = cal.get(Calendar.DAY_OF_WEEK);
		
		// 빈 날짜 넣기
		for (int i = 1; i<sYoil; i++)
		{
			boolean isTake = false;
			CalendarItem item = new CalendarItem(Integer.toString(y), Integer.toString(m), isTake);
			adt.add(item);
		}
		
		// 이번 달 마지막 날
		int lDay = getLastDay(y, m);
		
		for (int i=1; i<=lDay; i++)
		{
			boolean isTake = false;
			if (i%2 ==0)
				isTake = true;
			
			cal.set(y, cal.get(Calendar.MONTH), i);
			int yoil = cal.get(Calendar.DAY_OF_WEEK);
			
			CalendarItem item = new CalendarItem(Integer.toString(y), Integer.toString(m), Integer.toString(i), yoil, isTake);
			adt.add(item);
		}
		
		grid.setAdapter(adt);
	}
	
	// 이전 달
	public void doPrev(View v)
	{
		int y = cal.get(Calendar.YEAR);
		int m =cal.get(Calendar.MONTH)-1;
		cal.set(y, m, 1);
		
		doShow();
	}
	
	// 다음 달
	public void doNext(View v)
	{
		int y = cal.get(Calendar.YEAR);
		int m =cal.get(Calendar.MONTH)+1;
		cal.set(y, m, 1);
		
		doShow();
	}
	
	// 특정월의 마지막 날짜
	private int getLastDay(int year, int month)
	{
		Date d = new Date(year, month, 1);
		d.setHours(d.getDay()-1*24);
		SimpleDateFormat f = new SimpleDateFormat("dd");
		return Integer.parseInt(f.format(d));
	}
} 