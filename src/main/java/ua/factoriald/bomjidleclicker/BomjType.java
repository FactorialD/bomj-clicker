package ua.factoriald.bomjidleclicker;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public abstract class BomjType {



    public String name = "Blank";
    public int imageId;
    public long initBuyCost = 100;
    public long buyMultiplier = 5;
    public long initUpgradeCost = 100;
    public long count = 0;
    public long reward = 1;
    public Button addingButton;
    public TextView countTextView;
    public Button switchCountBuy;
    public TextView critTextView;
    public int switchCountValue = 1;


    //public EditText buyCountMultiplierView;

    private double critReward = 150;
    private double defaultReward = 100;

    MyRandom mr;

    public abstract void setBuyButton(int id);

    public abstract void setMultiplierButton(int id);

    public abstract void setCritView(int id);

    public abstract StepResult getStepResult();

    public void setInitBuyCost(long initBuyCost) {
        this.initBuyCost = initBuyCost;
    }

    public void setBuyMultiplier(long buyMultiplier) {
        this.buyMultiplier = buyMultiplier;
    }

    public void setInitUpgradeCost(long initUpgradeCost) {
        this.initUpgradeCost = initUpgradeCost;
    }

    public long getInitBuyCost() {
        return initBuyCost;
    }

    public long getBuyMultiplier() {
        return buyMultiplier;
    }

    public long getInitUpgradeCost() {
        return initUpgradeCost;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

//    public TextView getCountTextView() {
//        return countTextView;
//    }
//
//    public void setCountTextView(TextView countTextView) {
//        this.countTextView = countTextView;
//    }

//    public EditText getBuyCountMultiplierView() {
//        return buyCountMultiplierView;
//    }

//    public void setBuyCountMultiplierView(EditText buyCountMultiplierView) {
//        this.buyCountMultiplierView = buyCountMultiplierView;
//    }

    public long getReward() {
        return reward;
    }

    public void setReward(long reward) {
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getCritReward() {
        return critReward;
    }

    public void setCritReward(double critReward) {
        this.critReward = critReward;
    }

    public double getDefaultReward() {
        return defaultReward;
    }

    public void setDefaultReward(double defaultReward) {
        this.defaultReward = defaultReward;
    }

    public StepResult getLastStepResult() {
        return lastStepResult;
    }

    public void setLastStepResult(StepResult lastStepResult) {
        this.lastStepResult = lastStepResult;
    }

    public StepResult lastStepResult;
}
