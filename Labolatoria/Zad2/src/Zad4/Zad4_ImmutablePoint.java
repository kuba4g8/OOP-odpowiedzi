package Zad4;

import Utilities.Utils;

public class Zad4_ImmutablePoint {

    public static class Punkty
    {
        public Float x;
        public Float y;
        private Float dx;
        private Float dy;

        public Float[] moveBy(Float xMoved, Float yMoved)
        {
            dx = x + xMoved;
            dy = y + yMoved;
            Float[] tab = {dx, dy};
            return tab;
        }

        public void formatPoint()
        {
            Utils.print("Nie poruszone: " + x + " " + y);
            Utils.print("poruszone: " + dx + " " + dy);
        }
    }
}
