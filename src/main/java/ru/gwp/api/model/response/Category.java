package ru.gwp.api.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Pojo class for retrieving data from the body {@link ru.gwp.api.rest.RestResponse} as a result of
 * calling {@link ru.gwp.api.TheCatApi#getCategories()}
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Category {
  private int id;
  private String name;
}
