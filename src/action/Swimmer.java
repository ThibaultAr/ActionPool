package action;

import displayer.Displayer;
import exception.ActionFinishedException;
import pool.BasketPool;
import pool.CubiclePool;
import pool.resource.Basket;
import pool.resource.Cubicle;
import pool.user.ResourcefulUser;

/**
 * A Swimmer undresses in a cubicle, swims and dresses
 */
public class Swimmer extends SequentialScheduler {
	protected String name;

	public Swimmer(String name, BasketPool baskets, CubiclePool cubicles,
			int timeToUndress, int timeSwimming, int timeToDress) {
		this.name = name;
		ResourcefulUser<Basket> basketManager = new ResourcefulUser<Basket>();

		ResourcefulUser<Cubicle> cubicleManager = new ResourcefulUser<Cubicle>();

		Action getUndressed = new ForeseeableAction(timeToUndress, "undressing");
		Action swimming = new ForeseeableAction(timeSwimming, "swimming");
		Action getDressed = new ForeseeableAction(timeToDress, "dressing");

		this.actions
				.add(new TakeResourceAction<Basket>(basketManager, baskets));
		this.actions.add(new TakeResourceAction<Cubicle>(cubicleManager,
				cubicles));
		this.actions.add(getUndressed);
		this.actions.add(new FreeResourceAction<Cubicle>(cubicleManager,
				cubicles));
		this.actions.add(swimming);
		this.actions.add(new TakeResourceAction<Cubicle>(cubicleManager,
				cubicles));
		this.actions.add(getDressed);
		this.actions.add(new FreeResourceAction<Cubicle>(cubicleManager,
				cubicles));
		this.actions
				.add(new FreeResourceAction<Basket>(basketManager, baskets));

		this.isInitialized = true;
	}

	/**
	 * used by Display
	 */
	public String message() {
		return name + "'s turn \n " + name + " is ";
	}

	public void doStep() throws ActionFinishedException {
		Displayer.getDisplayer().display(name + "'s turn \n " + name + " is ");
		super.doStep();
	}

}
