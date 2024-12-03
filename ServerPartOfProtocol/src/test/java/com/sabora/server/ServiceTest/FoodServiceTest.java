package com.sabora.server.ServiceTest;

import com.sabora.server.Models.Food;
import com.sabora.server.Repositories.FoodRepository;
import com.sabora.server.Services.FoodService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.server.AutoConfigureMockWebServiceClient;

import java.math.BigDecimal;
import java.util.List;

public class FoodServiceTest {

    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private FoodService foodService;

    public FoodServiceTest(FoodRepository foodRepository, FoodService foodService) {
        this.foodRepository = foodRepository;
        this.foodService = foodService;
    }



    @Test
    public void testHighCalorieFood() {
        List<Food> foods = List.of(
                new Food(1,"Rice", "Compuesto de arroz", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(45)),
                new Food(2,"Salsa de soja", "Salsa altamente calórica", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(2000)),
                new Food(3,"Mejillones en escabeche", "Mejillones en su tinta", BigDecimal.valueOf(2000), BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(10),BigDecimal.valueOf(3))
        );

        Mockito.when(foodRepository.findAll()).thenReturn(foods);
        List<Food> highCalorieFoods = foodService.getHighCalorieFoods(foods);

        assert highCalorieFoods.size() == 1;
        assert highCalorieFoods.get(0).getName().equals("Salsa de soja");

    }

}
