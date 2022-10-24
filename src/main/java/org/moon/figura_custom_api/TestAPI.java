package org.moon.figura_custom_api;

import org.luaj.vm2.LuaError;
import org.moon.figura.avatar.Avatar;
import org.moon.figura.lua.FiguraAPI;
import org.moon.figura.lua.LuaNotNil;
import org.moon.figura.lua.LuaWhitelist;

import java.util.*;

@LuaWhitelist
public class TestAPI implements FiguraAPI {

    /**
     * test field
     */
    @LuaWhitelist
    public String testField = "My Field <3";

    /**
     * test immutable field
     */
    @LuaWhitelist
    public final String testImmutableField = "Share if you like the field";

    /**
     * this API instance
     */
    @Override
    public FiguraAPI build(Avatar avatar) {
        return new TestAPI();
    }

    /**
     * this API name
     */
    @Override
    public String getName() {
        return "test";
    }

    /**
     * classes that need to be whitelisted, including this API
     */
    @Override
    public Collection<Class<?>> getWhitelistedClasses() {
        return List.of(this.getClass());
    }

    /**
     * test method
     */
    @LuaWhitelist
    public String test() {
        return "This is a Test :3";
    }

    /**
     * test static method (do not require self as first argument)
     */
    @LuaWhitelist
    public static String testStatic() {
        return "StAtIc";
    }

    /**
     * test method 2 - with required arguments
     */
    @LuaWhitelist
    public String test2(@LuaNotNil Object arg1, Object arg2) {
        return arg1.toString() + arg2;
    }

    /**
     * test method 3 - error
     */
    @LuaWhitelist
    public String test3() {
        throw new LuaError("oh-no, my table...");
    }

    /**
     * test method 4 - array
     */
    @LuaWhitelist
    public List<String> test4() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }

    /**
     * test method 5 - table
     */
    @LuaWhitelist
    public Map<String, Integer> test5() {
        Map<String, Integer> map = new HashMap<>();
        map.put("strawberry", 5);
        map.put("chocolate", 2);
        map.put("vanilla", 2);
        return map;
    }

    /**
     * to access fields
     */
    @LuaWhitelist
    public Object __index(String arg) {
        if (arg == null) return null;
        return switch (arg) {
            case "testField" -> testField;
            case "testImmutableField" -> testImmutableField;
            default -> null;
        };
    }

    /**
     * to write on fields
     */
    @LuaWhitelist
    public void __newindex(String key, Object value) {
        if (key.equals("testField"))
            testField = value == null ? null : value.toString();
    }

    /**
     * used in "print()"
     */
    @Override
    public String toString() {
        return "TestAPI";
    }
}
