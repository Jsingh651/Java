package com.jang.DakichiCore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/dakichi")
public class DakichiCoreController {
		@RequestMapping("/travel/{city}")
		public String index(@PathVariable("city")String city) {
			return "Congrats! you will soon travel to "+ city;
		}
		
		@RequestMapping("/lotto/{number}")
		public String lotto(@PathVariable("number") String number) {
			int times = Integer.parseInt(number);
			if (times % 2 == 0) {
				return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
			else {
				return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
			}
		}
		
		
}
