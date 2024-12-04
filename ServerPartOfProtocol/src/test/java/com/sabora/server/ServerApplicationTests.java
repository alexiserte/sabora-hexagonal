package com.sabora.server;

import com.sabora.server.Models.Food;
import com.sabora.server.Repositories.FoodRepository;
import com.sabora.server.Services.FoodService;
import com.sabora.server.Services.Implementation.FoodServiceImplementation;
import com.sabora.server.Utils.FileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ServerApplicationTests {

	@Mock
	private FoodRepository foodRepository;

	@InjectMocks
	private FoodServiceImplementation foodService;

	@Test
	public void testHighCalorieFood() {
		List<Food> foods = List.of(
				new Food(1,"Rice", "Compuesto de arroz", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(45)),
				new Food(2,"Salsa de soja", "Salsa altamente calórica", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(2001)),
				new Food(3,"Mejillones en escabeche", "Mejillones en su tinta", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(3))
		);

		when(foodService.getAllFoods()).thenReturn(foods);

		List<Food> highCalorieFoods = foodService.getHighCalorieFoods(foodService.getAllFoods());

		assert highCalorieFoods.size() == 1;
		assert highCalorieFoods.get(0).getName().equals("Salsa de soja");
	}

	@Test
	public void testFileReader() {
		String fileContent = FileReader.leerArchivo("src/main/java/com/sabora/server/HTMLPages/bienvenida.html");
		assert fileContent.contains("Hello World!");
	}

}
