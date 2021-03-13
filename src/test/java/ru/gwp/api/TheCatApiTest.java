package ru.gwp.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.gwp.api.model.response.Category;
import ru.gwp.junit.AllureRestAssuredBeforeAll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.ThreadLocal.withInitial;
import static ru.gwp.ExampleApiModule.DIContainer.getInstance;
import static ru.gwp.report.Allure.tms;
import static ru.gwp.steps.assertion.BaseAssertionSteps.assertNotEmpty;

@Epic("The Cat Api Example Test")
@Feature("categories")
@Story("positive")
@ExtendWith(AllureRestAssuredBeforeAll.class)
public final class TheCatApiTest {

  private static final ThreadLocal<Map<String, Object>> STORAGE = withInitial(HashMap::new);
  private static final TheCatApiSteps THE_CAT_API_STEPS =
      getInstance(TheCatApiStepsFactory.class).create(STORAGE);

  @Test
  @DisplayName("Get categories request returns not empty list")
  @Tag("healthCheck")
  void getCategories_returnsNotEmptyList() {
    tms("test_case_id");
    List<Category> categories = THE_CAT_API_STEPS.getCategories();
    assertNotEmpty("Categories list", categories);
  }
}
