package com.alex.morgan.bearlist.list;

import com.alex.morgan.bearlist.Bear;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import javax.inject.Inject;
import javax.inject.Singleton;

import kotlin.jvm.JvmVersion;

@Singleton
class BearCache {

    private Collection<Bear> bears;

    @Inject
    public BearCache() {
        bears = Collections.emptySet();
    }

    public Collection<Bear> getBears() {
        return new ArrayList<>(bears);
    }

    public void putBears(Collection<Bear> bears) {
        this.bears = new ArrayList<>(bears);
    }
}
