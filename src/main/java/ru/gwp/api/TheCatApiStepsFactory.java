package ru.gwp.api;

import java.util.Map;

/** Provides a factory for creating steps to work with the The Cat API. */
public interface TheCatApiStepsFactory {

  /**
   * Creates The Cat API steps.
   *
   * @param storage stores test data during test execution.
   * @return The Cat API steps. Look {@link TheCatApiSteps}.
   */
  TheCatApiSteps create(ThreadLocal<Map<String, Object>> storage);
}
