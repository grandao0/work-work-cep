package com.cassio.cargacep.utils;

import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class Fetcher<S, T> {
    protected S source;

    protected Fetcher(S s) {
        this.source = s;
    }

    public abstract List<T> fetch(Pageable pageRequest);
}
