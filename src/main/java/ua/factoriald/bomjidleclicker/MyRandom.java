package ua.factoriald.bomjidleclicker;

public class MyRandom {

    public float[] getProcs() {
        return procs;
    }

    public byte[] getVals() {
        return vals;
    }

    private float[] procs;
    private byte[] vals;

    private int lessLength;

    public MyRandom(float[] procs, byte[] vals){
        this.procs = procs;
        this.vals = vals;

        this.lessLength = procs.length > vals.length ? vals.length : procs.length;

    }

    public int getIntFromTable(){

        double rand = ((short) (Math.random() * 10001))/10000.0;
        int i = 0;
        while(i < lessLength) {
            if(rand < procs[i]){
                return i;
            }
            i++;
        }
        return i;
    }



}
