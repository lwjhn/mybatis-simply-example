package com.rongji.egov.example.service;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.rongji.egov.example.service.model.SQLSelector1;
import com.rongji.egov.mybatis.base.model.SQLSelector;

import java.lang.reflect.Type;

public class SQLSelectorDeserializer  implements ObjectDeserializer {
    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        System.out.println(">>---type--->"+type.getTypeName());
        final JSONLexer lexer = parser.getLexer();
        System.out.println(">>---tokenName--->"+lexer.tokenName());
        System.out.println(">>---fieldName--->"+ String.valueOf(fieldName));
        if(lexer.token() == JSONToken.LBRACE){
            return (T) parser.parseObject(SQLSelector1.class);
        }else{
            return (T) parser.parseObject(String.class);
        }
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
/*
    @Override
    public  <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        final JSONLexer lexer = parser.getLexer();
        if (lexer.token() == JSONToken.LITERAL_STRING) {
            String val = lexer.stringVal();
            lexer.nextToken(JSONToken.COMMA);
            // 如果是空字符串，希望返回null
            if(val == null || "".equals(val.trim())){
                return  null;
            }
            return (T)val;
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }*/
}