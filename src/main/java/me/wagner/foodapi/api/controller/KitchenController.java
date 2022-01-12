package me.wagner.foodapi.api.controller;

import me.wagner.foodapi.api.model.KitchensXmlWrapper;
import me.wagner.foodapi.domain.model.Kitchen;
import me.wagner.foodapi.domain.repository.KitchenRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/kitchens", produces = MediaType.APPLICATION_JSON_VALUE)
public class KitchenController {

    private KitchenRepository kitchenRepository;

    public KitchenController(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    @GetMapping
    public List<Kitchen> list() {
        return kitchenRepository.list();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public KitchensXmlWrapper listXml() {
        return new KitchensXmlWrapper(kitchenRepository.list());
    }

    @GetMapping("/{id}")
    public Kitchen search(@PathVariable Long id) {
        return kitchenRepository.findById(id);
    }

}
