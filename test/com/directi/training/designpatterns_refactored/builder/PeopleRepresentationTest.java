package com.directi.training.designpatterns_refactored.builder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeopleRepresentationTest
{
    private List<Person> people;

    @Before
    public void initPersons()
    {
        people = new ArrayList<>(3);
        people.add(new Person("Wu", 25, "Shanghai", "China"));
        people.add(new Person("Kobayashi", 200, "Kanto", "Japan"));
        people.add(new Person("Vasily", 1, "Leningrad", "Russia"));
    }
    
    @Test
    public void testPeopleXml()
    {
        XmlBuilder builder = new XmlBuilder();
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                             "<people number=3>" +
                                "<person>" +
                                    "<id>25</id>" +
                                    "<name>Wu</name>" +
                                    "<address>" +
                                        "<city>Shanghai</city>" +
                                        "<country>China</country>" +
                                    "</address>" +
                                "</person>" +
                                "<person>" +
                                    "<id>200</id>" +
                                    "<name>Kobayashi</name>" +
                                    "<address>" +
                                        "<city>Kanto</city>" +
                                        "<country>Japan</country>" +
                                    "</address>" +
                                "</person>" +
                                "<person>" +
                                    "<id>1</id>" +
                                    "<name>Vasily</name>" +
                                    "<address>" +
                                        "<city>Leningrad</city>" +
                                        "<country>Russia</country>" +
                                    "</address>" +
                                "</person>" +
                             "</people>";
        PeopleRepresentation peopleRepresentation = new PeopleRepresentation(builder);
        peopleRepresentation.constructRepresentation(people);
        assertEquals(expectedXml, builder.getRepresentation());
    }

    @Test
    public void testPeopleJson()
    {
        JsonBuilder builder = new JsonBuilder();
        String expectedJson = "people:" +
                              "[" +
                              "{" +
                              "\"id\":25," +
                              "\"name\":\"Wu\"," +
                              "\"address\":" +
                                "{" +
                                    "\"city\":\"Shanghai\"," +
                                    "\"country\":\"China\"" +
                                "}" +
                              "}," +
                              "{" +
                              "\"id\":200," +
                              "\"name\":\"Kobayashi\"," +
                              "\"address\":" +
                                "{" +
                                    "\"city\":\"Kanto\"," +
                                    "\"country\":\"Japan\"" +
                                "}" +
                              "}," +
                              "{" +
                              "\"id\":1," +
                              "\"name\":\"Vasily\"," +
                              "\"address\":" +
                                "{" +
                                    "\"city\":\"Leningrad\"," +
                                    "\"country\":\"Russia\"" +
                                "}" +
                              "}" +
                              "]";
        PeopleRepresentation peopleRepresentation = new PeopleRepresentation(builder);
        peopleRepresentation.constructRepresentation(people);
        assertEquals(expectedJson, builder.getRepresentation());
    }
}