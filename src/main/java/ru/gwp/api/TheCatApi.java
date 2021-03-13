package ru.gwp.api;

import ru.gwp.api.rest.RestResponse;

/** Provides functionality to work with The Cat Api. Extends {@link BaseRestApi}. */
interface TheCatApi extends BaseRestApi {

  /**
   * Executes REST request to retrieve categories.
   *
   * @return REST response. Look {@link RestResponse}.
   */
  RestResponse getCategories();
}
