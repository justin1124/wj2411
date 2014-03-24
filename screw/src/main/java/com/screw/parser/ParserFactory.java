package com.screw.parser;

import java.util.HashMap;
import java.util.Map;

public class ParserFactory {

    private static final Map<String, Parser> map = new HashMap<String, Parser>();

    static {
        map.put(ParserConstants.STAX, new StAXParser());
    }

    public static Parser getParser(String parserName) {
        return map.get(parserName);
    }
}
