package com.vra.collapsiblecalendar.sample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.vra.collapsiblecalendar.view.Event;
import com.vra.collapsiblecalendar.widget.CollapsibleCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CollapsibleCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);
        calendarView.setCalendarListener(new CollapsibleCalendarView.CalendarListener() {
            @Override
            public void onDaySelected() {
                Log.d("onClicked", "onDaySelected");
            }

            @Override
            public void onMonthChanged() {
                Log.d("onClicked", "onMonthChanged");
            }

            @Override
            public void onWeekChanged(int position) {
                Log.d("onClicked", "onWeekChanged");
            }

            @Override
            public void onClicked() {
                Log.d("onClicked", "onClicked");
            }

            @Override
            public void onDayChanged() {
                Log.d("onDayChanged", "onDayChanged");
            }
        });
        loadLeadCountInCalendar();
    }

    private void loadLeadCountInCalendar() {
        AsyncTask.execute(() -> {
            try {
                Calendar cal = Calendar.getInstance();

                List<Event> events = new ArrayList<>();
                for (int i = 1; i <= 5; i++) {
                    com.vra.collapsiblecalendar.view.Event event = new com.vra.collapsiblecalendar.view.Event(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                    events.add(event);
                }
                calendarView.post(() -> calendarView.setEventTagList(events));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}