package ua.factoriald.bomjidleclicker;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Long.parseLong;


public class MainActivity extends AppCompatActivity {


    private static final String ATTRIBUTE_NAME = "name";
    private static final String ATTRIBUTE_IMG = "img";
    private static final String ATTRIBUTE_COUNT = "count";
    private static final String ATTRIBUTE_BUYBUTTON = "buybutton";
    private static final String ATTRIBUTE_CRIT = "crit";
    private static final String ATTRIBUTE_SWBUTTON = "swbutton";
//    public final int BOMJ1 = 100;
//    public final int BOMJ2 = 500;
//    public final int BOMJ3 = 2000;
//    public final int BOMJ4 = 10000;
//    public final int BOMJ5 = 50000;

//    public final int BOMJUP1 = 1;
//    public final int BOMJUP2 = 5;
//    public final int BOMJUP3 = 20;
//    public final int BOMJUP4 = 100;
//    public final int BOMJUP5 = 500;

    public Button work;

//    public Button up1;
//    public Button up2;
//    public Button up3;
//    public Button up4;
//    public Button up5;

    public TextView scoreView;
    public TextView speedView;
    public TextView count1View;
    public TextView count2View;
    public TextView count3View;
    public TextView count4View;
    public TextView count5View;

    BomjType[] bomji;

    public long score = 103;

    public final double tickSpeed = 0.5;
    public long speed = 0;

//    public long count1 = 1;
//    public long count2 = 0;
//    public long count3 = 0;
//    public long count4 = 0;
//    public long count5 = 0;

    ListView bomjiListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bomji = new BomjType[]{
                new BomjLevel1()
        };

        loadData();



//        // упаковываем данные в понятную для адаптера структуру
//        //ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(listname.size());
//        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(bomji.length);
//        Map<String, Object> m;
//        for (int i = 0; i < bomji.length; i++) {
//
//            m = new HashMap<String, Object>();
//            m.put(ATTRIBUTE_NAME,bomji[i].getName());
//            m.put(ATTRIBUTE_IMG,bomji[i].getImageId());
//            m.put(ATTRIBUTE_COUNT,"x" + bomji[i].getCount());
//            m.put(ATTRIBUTE_BUYBUTTON,bomji[i].initBuyCost + "$ \n +" +
//                bomji[i].reward + "$/с" );
//            m.put(ATTRIBUTE_CRIT,"");
//            m.put(ATTRIBUTE_SWBUTTON,"x" + bomji[i].switchCountValue);
//
//            //m.put(ATTRIBUTE_NAME_IMAGE, ("assets\\hero_little_icon\\" + listhero.get(i).img));
//
//            data.add(m);
//        }
//
//        // массив имен атрибутов, из которых будут читаться данные
//        String[] from = { ATTRIBUTE_NAME,
//                ATTRIBUTE_IMG,
//                ATTRIBUTE_COUNT,
//                ATTRIBUTE_BUYBUTTON,
//                ATTRIBUTE_CRIT,
//                ATTRIBUTE_SWBUTTON  };
//        // массив ID View-компонентов, в которые будут вставлять данные
//        int[] to = {R.id.list_name,
//                    R.id.list_image,
//                    R.id.list_count,
//                    R.id.list_buy,
//                    R.id.list_crit,
//                    R.id.list_multiplier,
//                    };

        // создаем адаптер
        //SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.bomj_item,from, to);
        MyAdapter sAdapter = new MyAdapter(this,this, R.layout.bomj_item);

        // определяем список и присваиваем ему адаптер
        bomjiListView = (ListView) findViewById(R.id.list_view);
        bomjiListView.setAdapter(sAdapter);

        Log.d("MainActivity",bomjiListView.getAdapter().getCount()+"");


        //Log.d("Dima: ", loadData() == null ? "date null": "date not null");
        work = (Button)findViewById(R.id.work);
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = setNewScore(1);
                rep();
            }
        });

//        up1 = (Button)findViewById(R.id.up1);
//        up1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count1 = tryBuy(BOMJ1, count1);
//                rep();
//            }
//        });
//
//        up2 = (Button)findViewById(R.id.up2);
//        up2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count2 = tryBuy(BOMJ2, count2);
//                rep();
//            }
//        });
//
//        up3 = (Button)findViewById(R.id.up3);
//        up3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count3 = tryBuy(BOMJ3, count3);
//                rep();
//            }
//        });
//
//        up4 = (Button)findViewById(R.id.up4);
//        up4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count4 = tryBuy(BOMJ4, count4);
//                rep();
//            }
//        });
//
//        up5 = (Button)findViewById(R.id.up5);
//        up5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count5 = tryBuy(BOMJ5, count5);
//                rep();
//            }
//        });

        scoreView = (TextView)findViewById(R.id.score);
        scoreView.setText(score+"");

        speedView = (TextView)findViewById(R.id.speed);
        updateSpeed();

//        count1View = (TextView)findViewById(R.id.count1);
//        count1View.setText(String.valueOf(count1));
//        count2View = (TextView)findViewById(R.id.count2);
//        count2View.setText(String.valueOf(count2));
//        count3View = (TextView)findViewById(R.id.count3);
//        count3View.setText(String.valueOf(count3));
//        count4View = (TextView)findViewById(R.id.count4);
//        count4View.setText(String.valueOf(count4));
//        count5View = (TextView)findViewById(R.id.count5);
//        count5View.setText(String.valueOf(count5));


        AsyncTask bgCnting = new AsyncTask(){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }

            @Override
            protected void onProgressUpdate(Object[] values) {
                super.onProgressUpdate(values);
                //scoreView.setText(score.toString());

            }

            @Override
            protected Object doInBackground(Object[] objects) {
                while(true){
                    score = setNewScore(tickSpeed);
                    try {
                        Thread.sleep((long)(tickSpeed*1000));

                        runOnUiThread(new Runnable(){
                            public void run(){
                                scoreView.setText(score+"");
                                Log.d("bgCount", "tick");
                            }});
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    }
                }


            }
        }.execute();

    }

    @Override
    protected void onStop() {
        super.onStop();
        saveData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void rep(){
        scoreView.setText(score + "");

        for (BomjType bomj: bomji
        ) {
            bomj.countTextView.setText("x"+ bomj.getCount());
        }

//        count1View.setText(String.valueOf(count1));
//        count2View.setText(String.valueOf(count2));
//        count3View.setText(String.valueOf(count3));
//        count4View.setText(String.valueOf(count4));
//        count5View.setText(String.valueOf(count5));

    }

    public void saveData(){

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor myEditor2 = myPreferences.edit();
        String time = String.valueOf( new Date().getTime());
        myEditor2.putString("score", score + "");
        myEditor2.putString("date", time);
//        myEditor2.putLong("count1",count1);
//        myEditor2.putLong("count2",count2);
//        myEditor2.putLong("count3",count3);
//        myEditor2.putLong("count4",count4);
//        myEditor2.putLong("count5",count5);
//        myEditor2.commit();

        for (int i = 0; i < bomji.length; i++) {
            myEditor2.putLong("count"+ (i+1), bomji[i].count);
        }
        myEditor2.commit();
        Log.d("Dima: ", "files saved");


//        FileOutputStream fos = null;
//        try {
//
//            String time = String.valueOf( new Date().getTime());
//            fos = openFileOutput("date.txt", Context.MODE_PRIVATE);
//            fos.write(time.getBytes());
//            Log.d("Dima: ", "file saved");
//            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
//        }
//        catch(Exception ex) {
//            ex.printStackTrace();
//            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            Log.d("Dima: ", "file not saved");
//        }
//        finally{
//            try{
//                if(fos!=null)
//                    fos.close();
//            }
//            catch(IOException ex){
//
//                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
    }
    // открытие файла
    public void loadData() {

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
        score = parseLong(myPreferences.getString("score", "103"));
        String time = myPreferences.getString("date", "");


        long last;
        try {
            last = parseLong(time);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            last = new Date().getTime();
        }
        long curr = new Date().getTime();
        long raz = (curr - last) /1000;

        Log.d("Dima: ", "passed from last time: " + raz + " seconds");

        long tmp = 0;
        for (int i = 0; i < bomji.length; i++) {
            bomji[i].setCount(myPreferences.getLong("count" + (i+1), 1));
            tmp += (bomji[i].getCount() * bomji[i].getReward() * bomji[i].mr.getProcs()[0] +
                    bomji[i].getCount() * bomji[i].getCritReward() * (1D - bomji[i].mr.getProcs()[0]));

        }

        score = score + tmp*raz;

//        count1 = myPreferences.getLong("count1", 1);
//        count2 = myPreferences.getLong("count2", 0);
//        count3 = myPreferences.getLong("count3", 0);
//        count4 = myPreferences.getLong("count4", 0);
//        count5 = myPreferences.getLong("count5", 0);
        Log.d("Dima: ", "got file: " + time);










//        FileInputStream fin = null;
//        try {
//            fin = openFileInput("date.txt");
//            byte[] bytes = new byte[fin.available()];
//            fin.read(bytes);
//            String text = new String (bytes);
//            //SimpleDateFormat s = new SimpleDateFormat();
//            //Date d =  s.parse(text);
//            Log.d("Dima: ", "got file");
//            return parseLong(text);
//
//        }  catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally{
//            try{
//                Log.d("Dima: ", "gotnt file");
//                if(fin!=null)
//                    fin.close();
//            }
//            catch(IOException ex){
//                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//        return 0;
    }

//    public long tryBuy(int sum, long count){
//        Log.d("Dima", "in tryBuy");
//        Log.d("Dima", "score.compareTo(BigInteger.valueOf(sum)) >= 0: "  + (score.compareTo(BigInteger.valueOf(sum)) >= 0));
//        if (score.compareTo(BigInteger.valueOf(sum)) >= 0){
//            score = score.add(BigInteger.valueOf(-sum));
//            updateSpeed();
//            return count+1;
//
//        }
//        else{
//            Toast.makeText(this, "Не хватает денег!", Toast.LENGTH_SHORT).show();
//
//        }
//        rep();
//        return count;
//    }

    public void updateSpeed() {

        for (BomjType bomj: bomji
             ) {
            speed+=bomj.count*bomj.getReward();
        }

        speedView.setText(speed + " $/s");
    }
    public void updateCrits(){
        for (BomjType bomj: bomji
        ) {
            if(bomj.getLastStepResult().combedCount != 0){
                bomj.critTextView.setVisibility(View.VISIBLE);
                bomj.critTextView.setText("крит х" + bomj.getLastStepResult().combedCount);
            }else {
                bomj.critTextView.setVisibility(View.INVISIBLE);
            }
        }
    }


    public long setNewScore(double timeSec){
        //Log.d("setnewScore", "timeSec is: " + timeSec);
        //Log.d("setnewScore", ""+(count1*BOMJUP1 + count2*BOMJUP2 + count3*BOMJUP3 + count4*BOMJUP4 + count5*BOMJUP5)  +  " " + timeSec );
        long tmp = 0;
        for (BomjType bomj:
             bomji) {
            tmp+= bomj.getStepResult().countResult;
        }
        updateCrits();
        return score + (long)(tmp*timeSec);

    }
}
