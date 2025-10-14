package Zad3;

public class Zad3_Rectangle
{
    public class Oblicz
    {
        static Integer width;
        static Integer heigth;

        public static Integer getWidth() {return width;}
        public static Integer getHeight() {return heigth;}
        public static void setWidth(Integer newWidth) {width = newWidth;}
        public static void setHeigt(Integer newHighth) {heigth = newHighth;}

        public static Integer area()
        {
            return width * heigth;
        }

        public static Integer obwod()
        {
            return 2 * width + 2 * heigth;
        }
    }
}
