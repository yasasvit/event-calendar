package classes;

/**
This class contains the information for the 6 locations
@author Pranav Gummaluri, Yasasvi Tallapaneni
*/

public enum Location {
    HLL114("HLL114", "Hill Center, Busch"),
    ARC103("ARC103", "Allison Road Classroom, Busch"),
    BE_AUD("BE_AUD", "Beck Hall, Livingston"),
    TIL232("TIL232", "Tillett Hall, Livingston"),
    AB2225("AB2225", "Academic Building, College Avenue"),
    MU302("MU302", "Murray Hall, College Avenue");

    private final String roomNumber;
    private final String buildingAndCampus;

    private Location(String roomNumber, String buildingAndCampus) {
        this.roomNumber = roomNumber;
        this.buildingAndCampus = buildingAndCampus;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBuildingAndCampus() {
        return buildingAndCampus;
    }

    public boolean equals(Location otherLocation) {
        return this == otherLocation;
    }
}
