package ru.gwp.constants;

import lombok.Getter;

/** Stores available headers. */
public enum Header {
  X_API_KEY("x-api-key");

  @Getter private final String name;

  Header(String name) {
    this.name = name;
  }
}
