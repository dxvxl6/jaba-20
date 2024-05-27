public class Main {
    public static void main(String[] args) {
        Clothing[] cl = {
                new t_shirt(clothes.XXS, 250, "розовый"),
                new trousers(clothes.M, 560, "зелёные"),
                new skirt(clothes.L, 8000, "фиолетовый"),
                new galstuk(clothes.S, 70, "жёлтый")
        };
        atelier Atelie = new atelier(cl);
        Atelie.to_clothe_woman();
        Atelie.to_clothe_man();
    }
}
enum clothes {
    XXS(32) {
        @Override
        String getDescription() {
            return "Взрослый размер";
        }
    },
    XS(34),
    S(36),
    M(40),
    L(42);
    int size;
    clothes(int size) {
        this.size = size;
    }
    String getDescription() {
        return "Взрослый размер";
    }
}
interface Man_Clothes {
    void to_clothe_man();
}
interface Woman_Clothes {
    void to_clothe_woman();
}
abstract class Clothing {
    clothes size;
    double price;
    String color;
    public Clothing(clothes size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }
}
class t_shirt extends Clothing implements Man_Clothes, Woman_Clothes {
    public t_shirt(clothes size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void to_clothe_man() {
        System.out.println("Мужская футболка размер:" + size + ", цена:" + price + ", цвет:" + color);
    }
    @Override
        public void to_clothe_woman() {
        System.out.println("Женская футболка размер:" + size + ", цена:" + price + ", цвет:" + color);
    }
}
class trousers extends Clothing implements Man_Clothes {
    public trousers(clothes size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void to_clothe_man() {
        System.out.println("Мужские штаны размер:" + size + ", цена:" + price + ", цвет:" + color);
    }
}
class skirt extends Clothing implements Woman_Clothes {
    public skirt(clothes size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void to_clothe_woman() {
        System.out.println("Женская юбка размер:" + size + ", цена:" + price + ", цвет:" + color);
    }
}
class galstuk extends Clothing implements Man_Clothes {
    public galstuk(clothes size, double price, String color) {
        super(size, price, color);
    }
    @Override
    public void to_clothe_man() {
        System.out.println("Мужской галстук размер:" + size + ", цена:" + price + ", цвет:" + color);
    }
}
class atelier implements Woman_Clothes, Man_Clothes {
    Clothing[] cl;
    atelier(Clothing[] cl) {
        this.cl = cl;
    }
    @Override
    public void to_clothe_woman() {
        for (Clothing c : cl) {
            if (c instanceof Woman_Clothes) {
                ((Woman_Clothes) c).to_clothe_woman();

            }
        }
    }
    @Override
    public void to_clothe_man() {
        for (Clothing c : cl) {
            if (c instanceof Man_Clothes) {
                ((Man_Clothes) c).to_clothe_man();
            }
        }
    }
}