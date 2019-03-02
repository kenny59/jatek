package hu.mileszez.hmm.jatek;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;

public class addCardView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card_view);
        final TextView name = findViewById(R.id.name);
        final SeekBar length = findViewById(R.id.length);
        final CalendarView date = findViewById(R.id.date);
        final TextView desc = findViewById(R.id.desc);
        final Button button = findViewById(R.id.button);
        final sql db = new sql(this);
        length.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("INFO", String.valueOf(length.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.setValues(String.valueOf(name), String.valueOf(desc));
                Log.d("INFO", String.valueOf(length.getProgress()));
                Log.d("INFO", String.valueOf(db.readValues(true)));
                //Action lista = new Action( 20181212, "buzimaci", "ok", 12);
            }
        });
    }
    private String join(Object... ab) {
        return ab.toString();
    }

}
