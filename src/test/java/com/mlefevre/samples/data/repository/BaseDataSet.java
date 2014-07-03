package com.mlefevre.samples.data.repository;

import java.io.InputStream;

public class BaseDataSet {

    private static final String DATASET_FOLDER = "/dataset/";


    public InputStream getFile(String name) {
        Class<?> clazz = BaseDataSet.class;
        InputStream stream = clazz.getResourceAsStream(DATASET_FOLDER + name);
        return stream;
    }


}
