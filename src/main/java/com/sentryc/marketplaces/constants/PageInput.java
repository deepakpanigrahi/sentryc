package com.sentryc.marketplaces.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInput {
    int pageNumber;
    int pageSize;
}
