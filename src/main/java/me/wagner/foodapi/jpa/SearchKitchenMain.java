package me.wagner.foodapi.jpa;

import me.wagner.foodapi.FoodApiApplication;
import me.wagner.foodapi.domain.model.Kitchen;
import me.wagner.foodapi.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class SearchKitchenMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRepository kitchenRepository = applicationContext.getBean(KitchenRepository.class);

        Kitchen kitchen = kitchenRepository.findById(1L);

        System.out.println(kitchen.getName());
    }
}
