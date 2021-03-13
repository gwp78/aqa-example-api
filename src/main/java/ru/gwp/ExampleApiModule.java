package ru.gwp;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Key;
import ru.gwp.api.TheCatApiStepsModule;

import static com.google.inject.Guice.createInjector;
import static com.google.inject.name.Names.named;
import static java.lang.Integer.valueOf;
import static java.lang.System.getenv;
import static ru.gwp.CoreModule.initNames;

/** Service class used by {@link com.google.inject.Guice} */
public final class ExampleApiModule extends AbstractModule {

  private static final String PROPERTIES_FILE_PATH = "example-api.properties";

  @Override
  protected void configure() {
    install(new CoreModule());
    install(new TheCatApiStepsModule());
    initNames(binder(), this.getClass().getClassLoader(), PROPERTIES_FILE_PATH);
  }

  /** Provides functionality for retrieving instances of classes using {@link Injector} */
  public static final class DIContainer {

    private static final Injector injector = createInjector(new ExampleApiModule());

    private DIContainer() {}

    /**
     * Creates bounded instance of class
     *
     * @param cls Class
     * @return Instance of given class
     */
    public static <T> T getInstance(Class<T> cls) {
      return injector.getInstance(cls);
    }

    /**
     * Retrieves string value by provided key
     *
     * @param key named key
     * @return string value
     */
    public static String getStringValueOf(String key) {
      String value = injector.getInstance(Key.get(String.class, named(key)));
      if (value == null || value.isBlank()) {
        value = getenv(key);
      }
      return value;
    }

    /**
     * Retrieves integer value by provided key
     *
     * @param key named key
     * @return integer value
     */
    public static Integer getIntegerValueOf(String key) {
      return valueOf(getStringValueOf(key));
    }
  }
}
