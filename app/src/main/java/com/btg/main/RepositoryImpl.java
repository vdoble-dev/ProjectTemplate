package com.btg.main;

import com.btg.api.ExternalAPI;
import com.btg.main.MainContract;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RepositoryImpl implements MainContract.Repository {

    private final ExternalAPI externalAPI;

    private final List<String> words = Arrays.asList("Hello", "from", "Repository");

    public RepositoryImpl(ExternalAPI externalAPI) {
        this.externalAPI = externalAPI;
    }

    @Override
    public String fetchMainText() {
        return String.join(" ", words);
    }

}
