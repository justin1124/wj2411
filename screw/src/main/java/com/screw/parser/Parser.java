package com.screw.parser;

import java.io.InputStream;

public interface Parser {

    void parse(InputStream inputStream, Object obj);
}
