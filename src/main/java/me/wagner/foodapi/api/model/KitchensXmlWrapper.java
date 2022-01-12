package me.wagner.foodapi.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NonNull;
import me.wagner.foodapi.domain.model.Kitchen;

import java.util.List;

@JacksonXmlRootElement(localName = "kitchens")
@Data
public class KitchensXmlWrapper {

    @JsonProperty("kitchen")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NonNull
    private List<Kitchen> kitchens;

}
