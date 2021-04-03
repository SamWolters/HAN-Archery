package archery.resources;

public class Resources {
    /**
     * Loads in the URL location of the resources
     */
    private static final String SRC_MAIN_RESOURCES = "src/main/resources/";


    /**
     * Sets the URL to a public variable
     */
    public static class Images {
        public static final String ARCHER = SRC_MAIN_RESOURCES + "archer/archer.png";
        public static final String BOW = SRC_MAIN_RESOURCES + "bow/bow.png";
        public static final String ARROW_TYPE_ONE = SRC_MAIN_RESOURCES + "arrows/arrow-type-1.png";
        public static final String ARROW_TYPE_TWO = SRC_MAIN_RESOURCES + "arrows/arrow-type-2.png";
        public static final String ARROW_TYPE_THREE = SRC_MAIN_RESOURCES + "arrows/arrow-type-3.png";
        public static final String ARROW_TYPE_FOUR = SRC_MAIN_RESOURCES + "arrows/arrow-type-4.png";

        public static final String TARGET_PERSON = SRC_MAIN_RESOURCES + "targetPerson/target-person.png";
        public static final String TARGET_ITEM_APPLE = SRC_MAIN_RESOURCES + "targetItems/apple.png";
        public static final String TARGET_ITEM_FLOWERPOT = SRC_MAIN_RESOURCES + "targetItems/flowerpot.png";
        public static final String TARGET_ITEM_BALLOON = SRC_MAIN_RESOURCES + "targetItems/balloon.png";
        public static final String TARGET_ITEM_VASE = SRC_MAIN_RESOURCES + "targetItems/vase.png";

        public static final String GROUND = SRC_MAIN_RESOURCES + "groundTexture/ground-texture.png";
        public static final String WALL = SRC_MAIN_RESOURCES + "wallTexture/wall-texture.png";
    }

    /**
     * Sets textsize to a public variable
     */
    public static class Text {
        public static int FONTSIZE_XS = 18;
        public static int FONTSIZE_S = 28;
        public static int FONTSIZE_M = 34;
        public static int FONTSIZE_L = 48;
        public static int FONTSIZE_XL = 54;
    }
}


