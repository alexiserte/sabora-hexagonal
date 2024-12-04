package com.sabora.server;

import com.sabora.server.Models.Food;
import com.sabora.server.Services.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ServerApplicationTests {
	@Test
	void contextLoads() {
	}

	@Autowired
	private FoodService foodService;

	@Test
	public void testHighCalorieFood() {
		List<Food> foods = List.of(
				new Food(1,"Rice", "Compuesto de arroz", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(45)),
				new Food(2,"Salsa de soja", "Salsa altamente calórica", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(2000)),
				new Food(3,"Mejillones en escabeche", "Mejillones en su tinta", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(3))
		);
		List<Food> highCalorieFoods = foodService.getHighCalorieFoods(foods);

		System.out.println(highCalorieFoods);

		assert highCalorieFoods.size() == 1;
		assert highCalorieFoods.get(0).getName().equals("Salsa de soja");

	}

}
