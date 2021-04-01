package archery.resources;

public class Resources {
    private static final String baseUrl = "src/main/resources/";


    public static class Images {
        public static final String ARCHER = baseUrl + "archer/archer.png";
        public static final String bow = baseUrl + "bow/bow.png";
        public static final String arrowTypeOne = baseUrl + "arrows/arrow-type-1.png";
        public static final String arrowTypeTwo = baseUrl + "arrows/arrow-type-2.png";
        public static final String arrowTypeThree = baseUrl + "arrows/arrow-type-3.png";
        public static final String arrowTypeFour = baseUrl + "arrows/arrow-type-4.png";

        public static final String targetPerson = baseUrl + "targetPerson/target-person.png";
        public static final String targetItemApple = baseUrl + "targetItems/apple.png";
//        public static final String arrowTypeFour = baseUrl + "arrows/arrow-type-4.png";
//        public static final String arrowTypeFour = baseUrl + "arrows/arrow-type-4.png";

        public static final String ground = baseUrl + "groundTexture/ground-texture.png";
        public static final String wall = baseUrl + "wallTexture/wall-texture.png";
    }

    public static class Text {
        public static int FONTSIZE_XS = 20;
        public static int FONTSIZE_S = 30;
        public static int FONTSIZE_M = 40;
        public static int FONTSIZE_L = 50;
        public static int FONTSIZE_XL = 60;
    }
}


