package me.wagner.foodapi.jpa;

import me.wagner.foodapi.FoodApiApplication;
import me.wagner.foodapi.domain.model.Restaurant;
import me.wagner.foodapi.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultRestaurantMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);

        List<Restaurant> restaurants = restaurantRepository.list();

        for (Restaurant restaurant : restaurants) {
            System.out.printf("%s - %.2f - %s - %s \n", restaurant.getName(), restaurant.getDeliveryFee(), restaurant.getKitchen().getId(), restaurant.getKitchen().getName());
        }
    }
}
