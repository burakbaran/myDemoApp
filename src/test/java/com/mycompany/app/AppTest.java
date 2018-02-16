package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    public void testNull(){
    	ArrayList<Integer> array = null;
    	ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(12));
    	ArrayList<String> array3 = new ArrayList<>(Arrays.asList("abc","sad", "asdsad"));
    	ArrayList<String> array4 = new ArrayList<>(Arrays.asList("ab","asdsdasda"));
    	assertEquals(null,new App().giveKey(array,array2,array3,array4));
    }
    public void testMultipleNull(){
    	ArrayList<Integer> array = null;
    	ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(12));
    	ArrayList<String> array3 = new ArrayList<>(Arrays.asList("abc","sad", "asdsad"));
    	ArrayList<String> array4 = null;
    	assertEquals(null,new App().giveKey(array,array2,array3,array4));
    }
    public void testString(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(111));
    	ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(12));
    	ArrayList<String> array3 = new ArrayList<>(Arrays.asList("abc"));
    	ArrayList<String> array4 = new ArrayList<>(Arrays.asList("ab"));
    	String s = "11112abcab";
    	assertEquals(s,new App().giveKey(array,array2,array3,array4)); //because one element random is just like that
    }
    public void testWhiteSpace(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(13,15,22,34));
    	ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(12,15,16));
    	ArrayList<String> array3 = new ArrayList<>(Arrays.asList("abc","sad", "asdsad"));
    	ArrayList<String> array4 = new ArrayList<>(Arrays.asList("ab","asdsdasda"));
    	String s = new App().giveKey(array,array2,array3,array4);
    	assertTrue(s.contains(" "));//there are 2 elements and there must be 1 whitespace
    }
    public void testNoWhiteSpace(){
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(13,15));
    	ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(12));
    	ArrayList<String> array3 = new ArrayList<>(Arrays.asList("abc","sad", "asdsad"));
    	ArrayList<String> array4 = new ArrayList<>(Arrays.asList("ab","asdsdasda"));
    	String s = new App().giveKey(array,array2,array3,array4);
    	assertFalse(s.contains(" ")); //there is 1 element in array2 
    }

   

    /*
      Rigourous Test :-)
     
    public void testApp()
    {
        assertTrue( true );
    }
   public void testFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertTrue(new App().search(array, 4));
    }

    public void testNotFound() {
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertFalse(new App().search(array, 5));
    }

    public void testEmptyArray() {
      ArrayList<Integer> array = new ArrayList<>();
      assertFalse(new App().search(array, 1));
    }

    public void testNull() {
      assertFalse(new App().search(null, 1));
    }
	*/
}
