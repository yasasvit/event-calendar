package classes;
/**
 Represents the location
 @author Pranav Gummaluri, Yasasvi Tallapaneni
 */
public enum Location {
    HLL114("HLL114", "Hill Center, Busch"),
    hll114("HLL114", "Hill Center, Busch"),
    ARC103("ARC103", "Allison Road Classroom, Busch"),
    arc103("ARC103", "Allison Road Classroom, Busch"),
    BE_AUD("BE_AUD", "Beck Hall, Livingston"),
    be_aud("BE_AUD", "Beck Hall, Livingston"),
    TIL232("TIL232", "Tillett Hall, Livingston"),
    til232("TIL232", "Tillett Hall, Livingston"),
    AB2225("AB2225", "Academic Building, College Avenue"),
    ab2225("AB2225", "Academic Building, College Avenue"),

    MU302("MU302", "Murray Hall, College Avenue"),
    mu302("MU302", "Murray Hall, College Avenue");
    private final String roomNumber;
    private final String buildingAndCampus;
    /**
     * Creates a location object with room number and building and campus
     * @param roomNumber of location object
     * @param buildingAndCampus of location object
     */
    private Location(String roomNumber, String buildingAndCampus) {
        this.roomNumber = roomNumber;
        this.buildingAndCampus = buildingAndCampus;
    }
    /**
     * Returns the room number
     * @return String representing the room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }
    /**
     * Returns the building and campus
     * @return String representing the building and campus
     */
    public String getBuildingAndCampus() {
        return buildingAndCampus;
    }
    /**
     * Checks if the two locations are equal
     * @param Location representing the other location
     * @return true if location is same, false otherwise
     */
    public boolean equals(Location otherLocation) {
        return this == otherLocation;
    }
    /**
     * Checks if the location is valid
     * @param String representing the location
     * @return true if location is valid, false otherwise
     */
    public static boolean isValid(String locationString) {
        for (Location location : Location.values()) {
            if (location.toString().equals(locationString)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Converts the location into a string
     * @return String representing hte location
     */
    public String getString() {
        return getRoomNumber().toUpperCase() + " (" + getBuildingAndCampus() + ")";
    }
}