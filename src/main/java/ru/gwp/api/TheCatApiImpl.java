package ru.gwp.api;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import ru.gwp.api.rest.RestRequest;
import ru.gwp.api.rest.RestResponse;

import static com.google.common.base.Preconditions.checkNotNull;
import static ru.gwp.ExampleApiModule.container;
import static ru.gwp.constants.Header.X_API_KEY;
import static ru.gwp.constants.RequestMethod.GET;

/**
 * Provides implementation of functionality to work with The Cat API. Extends {@link
 * BaseRestApiImpl}.
 */
final class TheCatApiImpl extends BaseRestApiImpl implements TheCatApi {

  private final String categoriesPath;

  @Inject
  TheCatApiImpl(
      @Named("baseExampleUri") String baseExampleUri,
      @Named("categoriesPath") String categoriesPath,
      RestRequest restRequest) {
    super(baseExampleUri, restRequest);
    this.categoriesPath = categoriesPath;
  }

  /**
   * Executes GET REST request with base path {@link TheCatApiImpl#categoriesPath} to retrieve
   * categories.
   *
   * @return REST response. Look {@link RestResponse}.
   */
  public final RestResponse getCategories() {
    String keyName = X_API_KEY.getName();
    RestResponse response =
        request()
            .addHeader(keyName, container().getStringValueOf(keyName))
            .setBasePath(categoriesPath)
            .execute(GET);
    return checkNotNull(response);
  }
}
