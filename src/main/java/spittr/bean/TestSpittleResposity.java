package spittr.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.cglib.core.MethodWrapper;
import org.springframework.stereotype.Component;

import spittr.Spittle;
import spittr.data.SpittleRepository;;
@Component
public class TestSpittleResposity implements SpittleRepository{
	private Date time;
	private List<Spittle> list = createSpittleList(20);

	@Override
	public List<Spittle> findSpittles(long max, int count) {
	    return createSpittleList(count);
	}
	
	@Override
	public Spittle findOne(long spittleId) {
		for(int i = 0;i <list.size();i++) {
			if(i==spittleId) {
				return list.get(i);
			}else {
				return new Spittle("there is no spittle you searched", new Date());
			}
			
		}
		return null;
	}
	
	public List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
	    for (int i=0; i < count; i++) {
	      spittles.add(new Spittle("Spittle " + i, new Date()));
	    }
	    return spittles;
	}

}
