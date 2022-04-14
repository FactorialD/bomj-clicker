package ua.factoriald.bomjidleclicker;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyRandomTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getIntFromTable() {
        byte [] test2 = new byte[]{1,2};
        MyRandom mr = new MyRandom(new float[]{.2F, .5F}, test2);
        int w = mr.getIntFromTable();

        Assert.assertTrue( w <= test2[test2.length-1] && w > 0 );
    }
}