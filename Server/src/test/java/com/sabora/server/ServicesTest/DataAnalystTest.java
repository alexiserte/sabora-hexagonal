package com.sabora.server.ServicesTest;

import com.sabora.server.Entities.DataAnalyst;
import com.sabora.server.Repositories.DataAnalystRepository;
import com.sabora.server.Services.Implementation.DataAnalystService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DataAnalystTest {

    @Mock
    private DataAnalystRepository dataAnalystRepository;

    @InjectMocks
    private DataAnalystService dataAnalystService;

    @Test
    void testGetDataAnalystUserTest(){
        //Arrange
        DataAnalyst dataAnalyst = new DataAnalyst();
        dataAnalyst.setUsername("test");
        dataAnalyst.setPassword("test");

        DataAnalyst dataAnalyst2 = new DataAnalyst();
        dataAnalyst2.setUsername("test2");
        dataAnalyst2.setPassword("test2");

        List<DataAnalyst> dataAnalysts = List.of(dataAnalyst, dataAnalyst2);
        when(dataAnalystRepository.findAll()).thenReturn(dataAnalysts);

        //Act
        DataAnalyst result = dataAnalystService.getUser("test");
        DataAnalyst result2 = dataAnalystService.getUser("test2");
        DataAnalyst result3 = dataAnalystService.getUser("test3");

        //Assert
        assert(result != null);
        assert(result2 != null);
        assert(result3 == null);

        assertEquals(result.getUsername(), "test");
        assertEquals(result2.getUsername(), "test2");
        assertEquals(result.getPassword(), "test");
        assertEquals(result2.getPassword(), "test2");
    }
}
