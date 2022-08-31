package org.moon.figura_custom_api;

import org.moon.figura.avatars.Avatar;
import org.moon.figura.lua.FiguraAPI;
import org.moon.figura.lua.LuaWhitelist;

@LuaWhitelist
public class TestAPI extends FiguraAPI {

    @Override
    public FiguraAPI build(Avatar avatar) {
        return new TestAPI();
    }

    @Override
    public String getName() {
        return "test";
    }

    @LuaWhitelist
    public String test() {
        return "This is a Test :3";
    }

    @Override
    public String toString() {
        return "TestAPI";
    }
}
