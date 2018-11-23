package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	private SpittleRepository spittleRespository;
	@Autowired
	public SpittleController(SpittleRepository spittleRespository) {
		this.spittleRespository = spittleRespository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value="max",defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value="count",defaultValue ="20") int count
			) {
		return spittleRespository.findSpittles(max, count);
		
	}
	
	@RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
	public String showSpittles(@PathVariable long spittleId, Model model) {
		model.addAttribute(spittleRespository.findOne(spittleId));
		return "spittle";
		
	}
	
}
