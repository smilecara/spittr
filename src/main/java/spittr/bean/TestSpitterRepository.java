package spittr.bean;

import org.springframework.stereotype.Component;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Component
public class TestSpitterRepository implements SpitterRepository{

	@Override
	public Spitter save(Spitter spitter) {
		
		return spitter;
	}
	
	@Override
	public Spitter findByUserName(String userName) {
		return new Spitter("Jack","Bauer",userName,"24hours");
	}

}
