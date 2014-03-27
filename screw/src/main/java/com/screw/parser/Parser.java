package com.screw.parser;

import java.io.InputStream;

public interface Parser {

    <T> T parse(InputStream inputStream, Class<?> clazz);
}
