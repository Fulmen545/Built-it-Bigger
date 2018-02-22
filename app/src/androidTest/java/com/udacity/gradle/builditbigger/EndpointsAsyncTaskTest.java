package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by richard.janitor on 19-Feb-18.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    MainActivityFragment mainActivityFragment = new MainActivityFragment();

    @Test
    public void testHouseOfJokes() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertTrue(result != null);
                signal.countDown();
            }
        };
        endpointsAsyncTask.execute(mainActivityFragment);
    }
}
