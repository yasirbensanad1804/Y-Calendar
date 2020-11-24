package com.example.y_calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;
    private TextView textViewdateresult;
    private Button btndatepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleDateFormat=new SimpleDateFormat("dd-mm-yyyy", Locale.US);

        textViewdateresult=findViewById(R.id.tv_dateresult);
        btndatepicker=findViewById(R.id.bt_datepicker);
        btndatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();

            }
        });
    }
    private void showDateDialog(){
        Calendar calendar =Calendar.getInstance();
        datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mothofyear , int dayofmonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year,mothofyear,dayofmonth);
                textViewdateresult.setText("Tanggal dipilih :"+simpleDateFormat.format(newDate.getTime()));
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

}
