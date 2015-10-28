package pool.user;

import pool.BasketPool;
import pool.CubiclePool;

public class Swimmer {
	protected String name;
	protected BasketPool pool;
	protected CubiclePool cubicles;
	protected int timeUndressed;
	protected int timeSwim;
	protected int timeDressed;
	
	public Swimmer(String name, BasketPool pool, CubiclePool cubicles, int timeUndressed, int timeSwim, int timeDressed){
		this.name = name;
		this.pool = pool;
		this.cubicles = cubicles;
		this.timeUndressed = timeUndressed;
		this.timeSwim = timeSwim;
		this.timeDressed = timeDressed;
	}
	
	
}
