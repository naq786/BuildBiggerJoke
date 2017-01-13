package com.example.nafeezq.buildbiggerjoke;
import org.junit.Test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{

    boolean jokeReceived;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }



    final CountDownLatch signal = new CountDownLatch(1);

    @Test

    public void asyncTest () throws  Exception {


        final EndpointsAsyncTask asyncTask = new EndpointsAsyncTask (new AsyncTaskListener<String>() {

            @Override
            public void onAsyncTaskComplete(String result) {

                if (result!=null&& result.length()>0){
                    jokeReceived = true;
                    assertEquals(jokeReceived,true);
                }

                signal.countDown();
            }

        });

        asyncTask.execute();
        signal.await(5, TimeUnit.SECONDS);
    }

}