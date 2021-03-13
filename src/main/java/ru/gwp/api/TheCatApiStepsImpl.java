package ru.gwp.api;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import io.qameta.allure.Step;
import ru.gwp.api.model.response.Category;
import ru.gwp.steps.api.BaseApiStepsImpl;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Arrays.asList;
import static org.apache.http.HttpStatus.SC_OK;

/** Provides implementation of steps to work with The Cat API. Extends {@link BaseApiStepsImpl}. */
final class TheCatApiStepsImpl extends BaseApiStepsImpl implements TheCatApiSteps {

  private final TheCatApi theCatApi;

  @Inject
  TheCatApiStepsImpl(TheCatApi theCatApi, @Assisted ThreadLocal<Map<String, Object>> storage) {
    super(storage);
    this.theCatApi = theCatApi;
  }

  /**
   * Executes REST request to retrieve categories. Calls {@link TheCatApi#getCategories()}.
   *
   * @return categories list. Look {@link Category}.
   */
  @Override
  @Step("Execute get categories request")
  public final List<Category> getCategories() {
    Category[] categories =
        theCatApi
            .getCategories()
            .expectStatusCode(SC_OK)
            .expectMatchesJsonSchema("schemas/theCatApi/categories.json")
            .extractAs(Category[].class);
    return asList(checkNotNull(categories));
  }
}
