package ru.gwp.api;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/** Service class used by {@link com.google.inject.Guice} */
public final class TheCatApiStepsModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TheCatApi.class).to(TheCatApiImpl.class);
    install(
        new FactoryModuleBuilder()
            .implement(TheCatApiSteps.class, TheCatApiStepsImpl.class)
            .build(TheCatApiStepsFactory.class));
  }
}
