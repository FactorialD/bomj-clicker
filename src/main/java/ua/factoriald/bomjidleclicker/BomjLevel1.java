package ua.factoriald.bomjidleclicker;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.Random;

public class BomjLevel1 extends BomjType {

    MainActivity ma;



    public BomjLevel1() {
        setInitBuyCost(100);
        setBuyMultiplier(5);
        setInitUpgradeCost(100);
        setDefaultReward(1);
        setCritReward(1.5);
        mr = new MyRandom(new float[]{0.99F}, new byte[]{1});
        setName("Бомж-нубас");
        setImageId(R.drawable.bomj1);

    }
    @Override
    public void setBuyButton(int id){
        addingButton = (Button) ma.findViewById(id);
        addingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryBuy();
                ma.rep();
            }
        });
    }

    @Override
    public void setMultiplierButton(int id){
        switchCountBuy = (Button) ma.findViewById(id);
        switchCountBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (switchCountValue){
                    case 1 : {
                        switchCountValue = 10;
                        break;
                    }
                    case 10 : {
                        switchCountValue = 100;
                        break;
                    }
                    case 100 : {
                        switchCountValue = 1000;
                        break;
                    }
                    case 1000 : {
                        switchCountValue = 1;

                    }
                    default: {
                        break;
                    }
                }
                switchCountBuy.setText("x"+ switchCountValue);
            }
        });
    }
    @Override
    public void setCritView(int id){
        critTextView = (TextView) ma.findViewById(id);
        Log.d("setCritView", "critTextView is:" + (critTextView != null));
    }

    public void tryBuy(){
        Log.d("Dima", "in tryBuy");
        Log.d("Dima", "score.compareTo(BigInteger.valueOf(sum)) >= 0: "  + (ma.score >= this.initBuyCost));
        if (ma.score >= this.initBuyCost){
            ma.score = ma.score - this.initBuyCost;
            ma.updateSpeed();
            ma.rep();
            count++;
        }
        else{
            Toast.makeText(ma, "Не хватает денег!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public StepResult getStepResult() {

        //brat napisal-> //ну пипта обьясняю як воно работае короче бомж сыдаэ на бутылку и вуаля грошы в кормані
        long critCount = 0;
        for (int i = 0; i < this.count; i++) {
            if (mr.getIntFromTable() > 0){
                critCount++;
            }
        }

        long result = (long)(getDefaultReward()*((double)critCount/this.count) + getCritReward()*((double)(this.count - critCount) / this.count));

        setLastStepResult(new StepResult(result, critCount));

        return getLastStepResult();

    }
}




















