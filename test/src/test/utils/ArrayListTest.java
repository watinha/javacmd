package test.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayListTest {

    @Test
    public void harnessTest () {
        org.junit.Assert.assertEquals(
            "Harness test... 4 should be equals to 3 + 1",
            (3 + 1), 4);
    }

}

