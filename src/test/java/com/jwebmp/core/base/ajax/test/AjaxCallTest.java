package com.jwebmp.core.base.ajax.test;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.base.ajax.AjaxCall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AjaxCallTest
        extends BaseTestClass
{
    @Test
    public void fromCall()
    {
        AjaxCall call = new AjaxCall();
        //call.setComponent(new CSSComponent("TestComponent"));
        call.setComponentId("ComponentID");
        call.setDatetime(new Date(2017, 11, 18));
        //call.setEventType(EventTypes.undefined);
        call.getParameters()
            .put("Test", "value");
        call.setClassName("classname");
        System.out.println(call.toString());

        Assertions.assertEquals(
                "{\n" +
                        //"  \"componentId\" : \"ComponentID\",\n" +
                        "  \"datetime\" : 61471692000000,\n" +
                        //"  \"eventType\" : \"undefined\",\n" +
                        "  \"parameters\" : {\n" +
                        "    \"Test\" : \"value\"\n" +
                        "  },\n" +
                        "  \"className\" : \"classname\"\n" +
                        "}",
                call.toString());
    }

}
