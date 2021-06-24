package com.cassio.cargacep.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PageableIterator<T> implements Iterator<T> {
    private static final int FIRST_PAGE = 0;

    private List<T> currentData;
    private int cursor;
    private final int pageSize;
    private Pageable page;
    private final Fetcher<?, T> fetcher;

    public PageableIterator(Fetcher<?, T> f, int pageSize) {
        this.fetcher = f;
        this.pageSize = pageSize;
        page = PageRequest.of(FIRST_PAGE, pageSize);
        currentData = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        if (hasDataLoaded()) {
            return true;
        }

        tryToFetchMoreData();
        return !currentData.isEmpty();
    }

    private void tryToFetchMoreData() {
        currentData = fetcher.fetch(page);
        page = PageRequest.of(page.getPageNumber() + 1, pageSize);
        cursor = 0;
    }

    private boolean hasDataLoaded() {
        return cursor < currentData.size();
    }

    @Override
    public T next() {
        return currentData.get(cursor++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
