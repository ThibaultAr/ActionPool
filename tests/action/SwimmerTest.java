package action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pool.BasketPool;
import pool.CubiclePool;
import exception.ActionFinishedException;

public class SwimmerTest extends SequentialSchedulerTest {

	@Test
	public void testInitialization(){
		Swimmer swimmer = new Swimmer("Damien", new BasketPool(2), new CubiclePool(2),1,1,1);
		assertEquals("Damien",swimmer.name);
	}
	
	@Test
	public void testSwimmer() throws ActionFinishedException{
		Swimmer swimmer = new Swimmer("Damien", new BasketPool(2), new CubiclePool(2),1,1,1);
		int nbSteps = 0;
		
		assertTrue(swimmer.isReady());
	
		while(!swimmer.isFinished()){
			swimmer.doStep();
			System.out.println("nbSteps : "+nbSteps);
			nbSteps++;
		}
		
		assertEquals(9, nbSteps);
		
	}
}
