package pageObjects;

public class GlobalStaticData {

    public static Integer price;

    public static class price {

        void setPrice(int p) {
            price = p;
        }

        Integer getPrice() {
            return price;
        }
    }
}

