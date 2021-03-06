package service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import recommendation.data.InputRating;
import recommendation.exceptions.ModelNotReadyException;
import recommendation.service.RecommendationService;

import java.util.ArrayList;

public class RecommendationServiceModelNotReadyTest {


    private static RecommendationService recommendationService;

    @BeforeClass
    public static void initModel() {
        ArrayList<InputRating> inputRatings = new ArrayList<>();
        inputRatings.add(new InputRating(1, 1, 1));
        recommendationService = new RecommendationService(inputRatings);
    }

    @AfterClass
    public static void close() {
        recommendationService.close();
    }

    @Test(expected = ModelNotReadyException.class)
    public void shouldNotForgetKnownRating() throws ModelNotReadyException {
        recommendationService.getPrediction(1, 1);
    }

}
