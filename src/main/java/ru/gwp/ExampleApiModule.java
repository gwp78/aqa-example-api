package ru.gwp;

import com.google.inject.AbstractModule;
import ru.gwp.api.TheCatApiStepsModule;

import static ru.gwp.CoreModule.initNames;

/** Service class used by {@link com.google.inject.Guice} */
public final class ExampleApiModule extends AbstractModule {

  private static final String PROPERTIES_FILE_PATH = "example-api.properties";
  private static final DIContainer CONTAINER = new DIContainer(new ExampleApiModule());

  @Override
  protected void configure() {
    install(new CoreModule());
    install(new TheCatApiStepsModule());
    initNames(binder(), this.getClass().getClassLoader(), PROPERTIES_FILE_PATH);
  }

  /**
   * Retrieves dependency injection container. Look {@link DIContainer}.
   *
   * @return static {@link ExampleApiModule#CONTAINER}.
   */
  public static DIContainer container() {
    return CONTAINER;
  }
}
