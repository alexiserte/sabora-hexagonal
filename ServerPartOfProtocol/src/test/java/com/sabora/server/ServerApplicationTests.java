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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
	public void testCorrectBehaviour() {
		FileReader reader = new FileReader();
		String readerResult = FileReader.leerArchivo("src/test/java/com/sabora/server/DataToTest/example_text.txt");
		assert readerResult.equals("Hello World!");
	}

	@Test
	public void testIncorrectBehaviour() {
		// Redirigir la salida estándar para capturar los mensajes impresos
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));
		try {
			FileReader reader = new FileReader();
			reader.leerArchivo("not/a/real/path");
		} finally {
			System.setOut(originalOut);
		}
		String printedOutput = outputStream.toString();
		assertTrue(printedOutput.contains("Error al leer el archivo:"));
	}
}
