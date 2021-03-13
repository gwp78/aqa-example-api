package ru.gwp.api;

import ru.gwp.api.model.response.Category;
import ru.gwp.steps.api.BaseApiSteps;

import java.util.List;

/** Provides steps to work with The Cat API. Extends {@link BaseApiSteps}. */
public interface TheCatApiSteps extends BaseApiSteps {

  /**
   * Executes REST request to retrieve categories.
   *
   * @return categories list. Look {@link Category}.
   */
  List<Category> getCategories();
}
