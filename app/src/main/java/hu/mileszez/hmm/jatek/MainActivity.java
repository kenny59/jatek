package hu.mileszez.hmm.jatek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Action lista = new Action(1, 20181212, 21121111, "buzimaci", "ok");
        print(lista.printInfo());
        print("OK");
    }

    public static void print(Object string) {
        Log.d("INFO", string.toString());
    }
}
