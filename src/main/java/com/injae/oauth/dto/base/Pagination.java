package com.injae.oauth.dto.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Pagination {
  private long limit;
  private long skip;
}
