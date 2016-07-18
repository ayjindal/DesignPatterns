package com.directi.training.designpatterns.builder;

import java.util.List;

public class PeopleRepresentation
{
    public static String getPeopleXml(List<Person> people)
    {
        String finalXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        finalXml += "<people number=" + people.size() + ">";
        for (Person person : people) {
            finalXml += "<person>" + "<id>" + person.getId() +
                        "</id>" + "<name>" + person.getName() + "</name>" +
                        "<address><city>" + person.getCity() + "</city><country>" +
                        person.getCountry() +
                        "</country></address>" +
                        "</person>";
        }
        finalXml += "</people>";
        return finalXml;
    }

    public static String getPeopleJson(List<Person> people)
    {
        String finalJson = "people:[";
        for (Person person : people) {
            finalJson += "{" + "\"id\":" + person.getId() + ",\"name\":\"" + person.getName() +
                         "\",\"address\":{" + "\"city\":\"" + person.getCity() +
                         "\",\"country\":\"" +
                         person.getCountry() +
                         "\"}}";
            finalJson += ",";
        }
        finalJson = finalJson.substring(0, finalJson.length() - 1);
        finalJson += "]";
        return finalJson;
    }
}
