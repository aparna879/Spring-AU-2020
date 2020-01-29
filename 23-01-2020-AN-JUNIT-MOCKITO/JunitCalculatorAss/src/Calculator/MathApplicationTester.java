package Calculator;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   @InjectMocks 
   MathApplication mathApplication = new MathApplication();

   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
	   
	   	when(calcService.add(10.0,20.0)).thenReturn(30.00);
	   	when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

		Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
//      Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
//      Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
        Assert.assertEquals(calcService.subtract(20.0, 10.0),10.0,0);
       
        InOrder inOrder = inOrder(calcService);
      
       inOrder.verify(calcService).add(10.0,20.0);//Success Case
       inOrder.verify(calcService).subtract(20.0,10.0);
//     verify(calcService, times(3)).add(10.0, 20.0); //Failure Case
       verify(calcService).add(10.0, 20.0); //Success Case
   }
   @Test
   public void testSubtract(){
	   
	      when(calcService.add(10.0,20.0)).thenReturn(30.00);
	      when(calcService.subtract(20.0,10.0)).thenReturn(10.0);

	      Assert.assertEquals(calcService.subtract(20.0, 10.0),10.0,0);
	      Assert.assertEquals(calcService.subtract(20.0, 10.0),10.0,0);
	      Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
	      
	       
	      InOrder inOrder = inOrder(calcService); //Success Case
	      inOrder.verify(calcService).subtract(20.0,10.0);
	      inOrder.verify(calcService).add(10.0,20.0);
     
	      verify(calcService, times(2)).subtract(20.0, 10.0); //Success Case

	      //verify(calcService).subtract(10.0, 20.0); //Failure CASE
	   }
   @Test
   public void testMultiply(){
	   
	      when(calcService.multiply(10.0,20.0)).thenReturn(200.00);
	      when(calcService.divide(20.0,10.0)).thenReturn(2.0);

	      Assert.assertEquals(calcService.multiply(10.0, 20.0),200.0,0);
	      Assert.assertEquals(calcService.divide(20.0, 10.0),2.0,0);
	      	       
//	      InOrder inOrder = inOrder(calcService); //Failure Case
//	      inOrder.verify(calcService).divide(20.0,10.0);
//	      inOrder.verify(calcService).multiply(10.0,20.0);
	      
//        verify(calcService, times(3)).multiply(20.0, 10.0); //Failure Case

	      verify(calcService).multiply(10.0, 20.0); //Success CASE
	   }

   @Test
   public void testDivide(){
	   
	   	  when(calcService.divide(20.0,10.0)).thenReturn(2.0);
	      when(calcService.multiply(10.0,20.0)).thenReturn(200.00);
	     
	      Assert.assertEquals(calcService.divide(20.0, 10.0),2.0,0);
	      Assert.assertEquals(calcService.multiply(10.0, 20.0),200.0,0);
	      	             
	      InOrder inOrder = inOrder(calcService); //Success Case
	      inOrder.verify(calcService).divide(20.0,10.0);
	      inOrder.verify(calcService).multiply(10.0,20.0);
	      
          verify(calcService, times(1)).divide(20.0, 10.0); //Success Case

//	      verify(calcService).divide(10.0, 20.0); //Failure CASE
	   }
}