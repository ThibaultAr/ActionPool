package action;

import pool.BasketPool;
import pool.resource.*;

import pool.user.ResourcefulUser;

public class TakeResourceActionTest extends ActionTest{

	@Override
	public Action createAction() {
		return new TakeResourceAction<Basket>(new ResourcefulUser<Basket>(),new BasketPool(0));
	}
	

}
