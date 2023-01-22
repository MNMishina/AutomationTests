package testResources;

import pojoMain.AddPlace;
import pojoMain.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name, String language, String address) {

        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91)9838933937");
        p.setName(name);

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        Location l = new Location();
        l.setLat(-38.384524);
        l.setLng(33.245876);
        p.setLocation(l);
        return p;
    }

    public String deletePlacePayload(String placeId)
    {
        return "{\r\n \"place_id\":\""+placeId+"\" \r\n}";
    }
}
