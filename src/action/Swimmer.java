package action;

import pool.BasketPool;
import pool.CubiclePool;
import pool.resource.Basket;
import pool.resource.Cubicle;
import pool.user.ResourcefulUser;

public class Swimmer extends SequentialScheduler {
	protected String name;
	
	public Swimmer(String name, BasketPool baskets, CubiclePool cubicles, int timeToUndress, int timeSwimming, int timeToDress){
		this.name = name;
		ResourcefulUser<Basket> basketManager = new ResourcefulUser<Basket>();
	
		ResourcefulUser<Cubicle> cubicleManager = new ResourcefulUser<Cubicle>();
	
		Action getUndressed = new ForeseeableAction(timeToUndress);
		Action swimming = new ForeseeableAction(timeSwimming);
		Action getDressed = new ForeseeableAction(timeToDress);
		
		this.actions.add(new TakeResourceAction<Basket>(basketManager,baskets));
		this.actions.add(new TakeResourceAction<Cubicle>(cubicleManager,cubicles));
		this.actions.add(getUndressed);
		this.actions.add(new FreeResourceAction<Cubicle>(cubicleManager,cubicles));
		this.actions.add(swimming);
		this.actions.add(new TakeResourceAction<Cubicle>(cubicleManager,cubicles));
		this.actions.add(getDressed);
		this.actions.add(new FreeResourceAction<Cubicle>(cubicleManager,cubicles));
		this.actions.add(new FreeResourceAction<Basket>(basketManager,baskets));
		
		this.isInitialized = true;
	}
	
}
