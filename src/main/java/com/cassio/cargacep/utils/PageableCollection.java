package com.cassio.cargacep.utils;

import java.util.Iterator;

public class PageableCollection<T> implements Iterable<T> {
    private static final int DEFAULT_PAGE_SIZE = 100;

    private final Fetcher<?, T> fetcher;
    private final int pageSize;

    public PageableCollection(Fetcher<?, T> f) {
        this(f, DEFAULT_PAGE_SIZE);
    }

    public PageableCollection(Fetcher<?, T> f, int pageSize) {
        this.fetcher = f;
        this.pageSize = pageSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new PageableIterator<>(fetcher, pageSize);
    }
}
