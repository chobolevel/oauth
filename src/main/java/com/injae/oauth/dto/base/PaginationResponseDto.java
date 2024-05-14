package com.injae.oauth.dto.base;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaginationResponseDto<T> {
  private long totalCount;
  private long skipCount;
  private long limitCount;
  private List<T> data;
}
