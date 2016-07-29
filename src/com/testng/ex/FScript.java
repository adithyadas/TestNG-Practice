package com.testng.ex;

import org.testng.annotations.Test;

public class FScript {
  @Test(dependsOnMethods={"fifth"}) //This will only run after the fifth method in this class. 
  public void first() {
	  System.out.println("Ducati Scrambler");
  }
  @Test(enabled=false)    			//Attributes of @Test
  public void second() {
	  System.out.println("Ducati 821 Carbon");
  }
  
//Another @Test attribute is invocationCount:The number of times this method should be invoked. invocationTimeOut is the cap on sum of time reqd for all invocations.
//invocationTimeOut is ignored if invocationCount is not specified.
  @Test(invocationCount=3, invocationTimeOut=3000) //This method will be run thrice. This will also affect total methods run count unless you also have the timeout specified. 
  public void third() {
	  System.out.println("Ducati 1299 Panigale");
  }
  //Prority is a hackjob way of enforcing order. 
  @Test(timeOut=3000, priority=2)   //Attributes of @Test. Remember, default prority is 0. 
  public void fourth() throws InterruptedException {
	  Thread.sleep(1000);
	  System.out.println("Ducati Multistrada");
  }
  

  @Test
  public void fifth() {
	  System.out.println("Ducati 795");
  }
}
