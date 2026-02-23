import java.util.Scanner;
class Product {
    String name;
    String brand;
    String ram;
    String storage;
    String color;
    int price;
    public Product() {
    }
    public Product(String name, String brand, String ram, String storage, String color, int price) {
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.color = color;
        this.price = price;
    }
	public Product(String string, String string2, String string3, String string4, String string5, String string6,
			int i) {
	}
}
class Customer {
    String name;
    String phone;
}
public class Ecommerce {
    static Scanner sc = new Scanner(System.in);
    static final String RESET = "\u001B[0m";
    static final String BLUE = "\u001B[34m";     
    static final String PURPLE = "\u001B[35m";   
    static final String CYAN = "\u001B[36m";    
    static final String YELLOW = "\u001B[33m";   
    static final String WHITE = "\u001B[37m";    
    static final String GREEN = "\u001B[32m";    
    static final String RED = "\u001B[31m";
    static Product[] cart = new Product[50];
    static int cartCount = 0;
    static Customer customer = new Customer();
    public static void main(String[] args) {
        System.out.print("Enter Customer Name: ");
        customer.name = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        customer.phone = sc.nextLine();
        while (true) {
        	System.out.println("\n==== MAIN MENU ====");
        	System.out.println(BLUE + "1. Electronics" + RESET);
        	System.out.println(PURPLE + "2. Home Decor" + RESET);
        	System.out.println(CYAN + "3. Fashion" + RESET);
        	System.out.println(YELLOW + "4. Stationery" + RESET);
        	System.out.println(WHITE + "5. Groceries" + RESET);
        	System.out.println(GREEN + "6. Checkout" + RESET);
        	System.out.println(RED + "7. Exit" + RESET);
            int choice = sc.nextInt();
            switch (choice) {
            case 1 -> electronics();
            case 2 -> homeDecor1();
            case 3 -> fashion1();
            case 4 -> stationery1();
            case 5 -> groceries1();
            case 6 -> checkout();
            case 7 -> System.exit(0);
            default -> System.out.println(RED + "Invalid choice" + RESET);
        }
        }
    }
    static void electronics() {
        while (true) {
            System.out.println(BLUE + "\n--- ELECTRONICS ---" + RESET);
            System.out.println("1. Mobiles");
            System.out.println("2. Laptops");
            System.out.println("3. Power Banks");
            System.out.println("4. Headphones");
            System.out.println("5. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> electronicsMobiles();
                case 2 -> electronicsLaptops();
                case 3 -> electronicsPowerBanks();
                case 4 -> electronicsHeadphones();
                case 5 -> { return; }
                default -> System.out.println(RED + "Invalid choice" + RESET);
            }
        }
    }
    static void homeDecor1() {
        while (true) {
            System.out.println(PURPLE + "\n--- HOME DECOR ---" + RESET);
            System.out.println("1. Wall Decor");
            System.out.println("2. Lighting");
            System.out.println("3. Furnishing");
            System.out.println("4. Showpieces");
            System.out.println("5. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> wallDecor();
                case 2 -> homeDecorLighting();
                case 3 -> homeDecorFurnishing();
                case 4 -> homeDecorShowpieces();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }
	static void fashion1() {
        while (true) {
            System.out.println(CYAN + "\n--- FASHION ---" + RESET);
            System.out.println("1. Men Wear");
            System.out.println("2. Women Wear");
            System.out.println("3. Footwear");
            System.out.println("4. Accessories");
            System.out.println("5. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> menWear();
                case 2 -> womenWear();
                case 3 -> footwear();
                case 4 -> accessories();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }
	static void stationery1() {
        while (true) {
            System.out.println(YELLOW + "\n--- STATIONERY ---" + RESET);
            System.out.println("1. Pens");
            System.out.println("2. Notebooks");
            System.out.println("3. Art & Craft");
            System.out.println("4. Office Supplies");
            System.out.println("5. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> pens();
                case 2 -> notebooks();
                case 3 -> artAndCraft();
                case 4 -> officeSupplies();
                case 5 -> { return; }
            }
        }
    } 
	static void groceries1() {
        while (true) {
            System.out.println(WHITE + "\n--- GROCERIES ---" + RESET);
            System.out.println("1. Fruits & Vegetables");
            System.out.println("2. Beverages");
            System.out.println("3. Snacks");
            System.out.println("4. Staples");
            System.out.println("5. Back");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> fruitsVegetables();
                case 2 -> beverages();
                case 3 -> snacks();
                case 4 -> staples();
                case 5 -> { return; }
            }
        }
    }
	static Product create(String n,String b,String r,String s,String c,int p) {
        return new Product(n,b,r,s,c,p);
    }
    static void displayProducts(Product[] products, String color) {
        for (int i = 0; i < products.length; i++) {
            System.out.println(color +
                    (i + 1) + ". " + products[i].name +
                    " | Brand: " + products[i].brand +
                    " | RAM: " + products[i].ram +
                    " | Storage: " + products[i].storage +
                    " | Color: " + products[i].color +
                    " | Price: ₹" + products[i].price +
                    RESET);
        }
        System.out.print("Select product (0 to back): ");
        int ch = sc.nextInt();
        if (ch > 0 && ch <= products.length) {
            cart[cartCount++] = products[ch - 1];
            System.out.println(GREEN + "Added to Cart ✅" + RESET);
        }
    }
    static void checkout() {
        if (cartCount == 0) {
            System.out.println(RED + "Cart is Empty" + RESET);
            return;
        }
        int total = 0;
        System.out.println(GREEN + "\n========== BILL RECEIPT ==========" + RESET);
        System.out.println("Customer: " + customer.name);
        System.out.println("Mobile  : " + customer.phone);
        System.out.println("---------------------------------");
        System.out.printf("%-25s %10s\n","Product","Price");
        System.out.println("---------------------------------");
        for (int i = 0; i < cartCount; i++) {
            System.out.printf("%-25s %10d\n", cart[i].name, cart[i].price);
            total += cart[i].price;
        }
        System.out.println("---------------------------------");
        System.out.printf("%-25s %10d\n","TOTAL", total);
        System.out.println(GREEN + "\nSelect Payment Method:" + RESET);
        System.out.println("1. UPI");
        System.out.println("2. Credit/Debit Card");
        System.out.println("3. Cash on Delivery");
        System.out.print("Enter option: ");
        int payChoice = sc.nextInt();
        sc.nextLine();
        switch (payChoice) {
            case 1 -> {
                System.out.print("Enter UPI ID: ");
                String upi = sc.nextLine();
                System.out.println(GREEN + "Payment of ₹" + total + " successful via UPI (" + upi + ") ✅" + RESET);
            }
            case 2 -> {
                System.out.print("Enter Card Number: ");
                String card = sc.nextLine();
                System.out.print("Enter Expiry Date (MM/YY): ");
                String expiry = sc.nextLine();
                System.out.print("Enter CVV: ");
                String cvv = sc.nextLine();
                System.out.println(GREEN + "Payment of ₹" + total + " successful via Card ✅" + RESET);
            }
            case 3 -> System.out.println(GREEN + "Order placed. Pay ₹" + total + " on delivery ✅" + RESET);
            default -> System.out.println(RED + "Invalid Payment Option. Payment Cancelled ❌" + RESET);
        }
        cartCount = 0;
    }
    static void electronicsMobiles() {
        System.out.println(BLUE + "\n--- ELECTRONICS : MOBILES ---" + RESET);
        Product[] mobiles = new Product[10];
        mobiles[0] = create("Samsung Galaxy S24 Ultra","Samsung","12GB","256GB","Black",129999);
        mobiles[1] = create("iPhone 15 Pro","Apple","8GB","256GB","Silver",134900);
        mobiles[2] = create("OnePlus 12","OnePlus","12GB","256GB","Green",69999);
        mobiles[3] = create("Google Pixel 8","Google","8GB","128GB","Hazel",75999);
        mobiles[4] = create("Xiaomi 14","Xiaomi","12GB","256GB","White",64999);
        mobiles[5] = create("Vivo X100","Vivo","12GB","256GB","Blue",63999);
        mobiles[6] = create("Oppo Find X7","Oppo","12GB","256GB","Black",72999);
        mobiles[7] = create("Realme GT 6","Realme","12GB","256GB","Grey",39999);
        mobiles[8] = create("Motorola Edge 50","Motorola","12GB","256GB","Peach",36999);
        mobiles[9] = create("Nothing Phone 2","Nothing","12GB","256GB","White",44999);
        displayProducts(mobiles, BLUE);
    }
    static void electronicsLaptops() {
        Product[] laptops = new Product[10];
        laptops[0] = create("Dell XPS 13","Dell","16GB","512GB SSD","Silver",139999);
        laptops[1] = create("MacBook Air M2","Apple","16GB","512GB SSD","Space Grey",149900);
        laptops[2] = create("HP Spectre x360","HP","16GB","1TB SSD","Black",129999);
        laptops[3] = create("Lenovo ThinkPad X1","Lenovo","16GB","1TB SSD","Black",159999);
        laptops[4] = create("Asus ROG Zephyrus","Asus","32GB","1TB SSD","Grey",189999);
        laptops[5] = create("Acer Predator Helios","Acer","16GB","1TB SSD","Blue",149999);
        laptops[6] = create("MSI Stealth 15","MSI","16GB","1TB SSD","Black",169999);
        laptops[7] = create("Samsung Galaxy Book 3","Samsung","16GB","512GB SSD","Silver",119999);
        laptops[8] = create("LG Gram 16","LG","16GB","1TB SSD","White",139999);
        laptops[9] = create("Microsoft Surface Laptop 5","Microsoft","16GB","512GB SSD","Platinum",149999);
        displayProducts(laptops, BLUE);
    }
    static void electronicsHeadphones() {
        Product[] headphones = new Product[10];
        headphones[0] = create("Sony WH-1000XM5","Sony","-","Wireless","Black",34999);
        headphones[1] = create("Bose QC45","Bose","-","Wireless","White",32999);
        headphones[2] = create("Apple AirPods Pro","Apple","-","Wireless","White",24999);
        headphones[3] = create("Sennheiser Momentum 4","Sennheiser","-","Wireless","Black",36999);
        headphones[4] = create("JBL Tour One","JBL","-","Wireless","Grey",29999);
        headphones[5] = create("Boat Rockerz 550","Boat","-","Wireless","Red",1999);
        headphones[6] = create("Skullcandy Crusher","Skullcandy","-","Wireless","Black",15999);
        headphones[7] = create("Beats Studio 3","Beats","-","Wireless","Blue",29999);
        headphones[8] = create("Noise Cancelling 450","Noise","-","Wireless","Grey",4999);
        headphones[9] = create("AKG N700NC","AKG","-","Wireless","Black",17999);
        displayProducts(headphones, BLUE);
    }
    static void electronicsPowerBanks() {
        Product[] powerbanks = new Product[10];
        powerbanks[0] = create("Mi Power Bank 20000mAh","Mi","-","20000mAh","Black",2199);
        powerbanks[1] = create("Realme 20000mAh","Realme","-","20000mAh","Yellow",1999);
        powerbanks[2] = create("Samsung 10000mAh","Samsung","-","10000mAh","White",2499);
        powerbanks[3] = create("Ambrane 20000mAh","Ambrane","-","20000mAh","Black",1899);
        powerbanks[4] = create("Anker PowerCore","Anker","-","26800mAh","Black",6499);
        powerbanks[5] = create("URBN 20000mAh","URBN","-","20000mAh","Green",2299);
        powerbanks[6] = create("Syska 10000mAh","Syska","-","10000mAh","Blue",1499);
        powerbanks[7] = create("Portronics Luxcell","Portronics","-","10000mAh","White",1399);
        powerbanks[8] = create("Redmi Power Bank","Redmi","-","20000mAh","Black",2099);
        powerbanks[9] = create("pTron Dynamo","pTron","-","10000mAh","Grey",999);
        displayProducts(powerbanks, BLUE);
    }
    static void wallDecor() {
        Product[] wallDecor = new Product[10];
        wallDecor[0] = create("Wooden Wall Clock","Ajanta","-","-","Brown",1999);
        wallDecor[1] = create("Metal Wall Art","Home Centre","-","-","Black",3499);
        wallDecor[2] = create("Canvas Painting","Art Street","-","-","Multicolor",2499);
        wallDecor[3] = create("Photo Frame Set","IKEA","-","-","Black",1499);
        wallDecor[4] = create("Wall Mirror","Urban Ladder","-","-","Silver",5999);
        wallDecor[5] = create("Wall Shelves","Pepperfry","-","-","White",4299);
        wallDecor[6] = create("3D Wall Stickers","Decals","-","-","Gold",999);
        wallDecor[7] = create("Wall Hanging","CraftVatika","-","-","Brown",1299);
        wallDecor[8] = create("Decorative Plates","Chumbak","-","-","Blue",1799);
        wallDecor[9] = create("LED Wall Frame","Philips","-","-","Warm White",2999);
        displayProducts(wallDecor, PURPLE);
    }
    static void homeDecorLighting() {
        Product[] lighting = new Product[10];
        lighting[0] = create("Table Lamp","Philips","-","-","Yellow",2499);
        lighting[1] = create("Floor Lamp","Wipro","-","-","White",6999);
        lighting[2] = create("Pendant Light","Havells","-","-","Black",5499);
        lighting[3] = create("LED Ceiling Light","Syska","-","-","White",3999);
        lighting[4] = create("Smart LED Bulb","Mi","-","-","White",899);
        lighting[5] = create("Wall Light","Orient","-","-","Warm White",2999);
        lighting[6] = create("Study Lamp","Panasonic","-","-","Grey",1999);
        lighting[7] = create("Decorative Lantern","HomeTown","-","-","Gold",3499);
        lighting[8] = create("Night Lamp","Portronics","-","-","Blue",1299);
        lighting[9] = create("Chandelier","Jaquar","-","-","Crystal",19999);
        displayProducts(lighting, PURPLE);
    }
    static void homeDecorFurnishing() {
        Product[] furnishing = new Product[10];
        furnishing[0] = create("Cotton Bedsheet","Bombay Dyeing","-","King Size","Blue",2499);
        furnishing[1] = create("Sofa Cover","Urban Ladder","-","3 Seater","Grey",1999);
        furnishing[2] = create("Curtains","IKEA","-","9 Feet","Beige",2999);
        furnishing[3] = create("Cushion Covers","Spaces","-","Set of 5","Multicolor",1499);
        furnishing[4] = create("Carpet","Safavieh","-","5x7 ft","Brown",7999);
        furnishing[5] = create("Blanket","Raymond Home","-","Double Bed","Maroon",3499);
        furnishing[6] = create("Pillow Set","Sleepyhead","-","Pack of 2","White",1299);
        furnishing[7] = create("Mattress Protector","Wakefit","-","Queen Size","White",1999);
        furnishing[8] = create("Door Mat","Status","-","Large","Black",899);
        furnishing[9] = create("Chair Cover","Home Sizzler","-","Set of 4","Brown",1799);
        displayProducts(furnishing, PURPLE);
    }
    static void homeDecorShowpieces() {
        Product[] showpieces = new Product[10];
        showpieces[0] = create("Buddha Statue","CraftVatika","-","-","Gold",2999);
        showpieces[1] = create("Ganesha Idol","eCraftIndia","-","-","Brass",3499);
        showpieces[2] = create("Deer Showpiece","HomeTown","-","-","White",2499);
        showpieces[3] = create("Abstract Sculpture","Chumbak","-","-","Black",3999);
        showpieces[4] = create("Crystal Swan","CrystalCraft","-","-","Transparent",4999);
        showpieces[5] = create("Wooden Elephant","Rajasthani Art","-","-","Brown",1999);
        showpieces[6] = create("Glass Vase","IKEA","-","-","Blue",1799);
        showpieces[7] = create("Metal Horse","Pepperfry","-","-","Copper",4299);
        showpieces[8] = create("Resin Couple","Home Decor Hub","-","-","Multicolor",2299);
        showpieces[9] = create("Sand Art Frame","Moving Sand","-","-","Blue",1599);
        displayProducts(showpieces, PURPLE);
    }
    static void menWear() {
        Product[] p = new Product[10];
        p[0]=create("Formal Shirt","Arrow","-","M","White",2200);
        p[1]=create("Casual Shirt","Levis","-","L","Blue",2100);
        p[2]=create("T-Shirt","Puma","-","M","Black",1500);
        p[3]=create("Jeans","Levis","-","32","Blue",3000);
        p[4]=create("Track Pant","Nike","-","L","Grey",2800);
        p[5]=create("Hoodie","H&M","-","M","Brown",2500);
        p[6]=create("Kurta","Manyavar","-","L","Cream",3500);
        p[7]=create("Blazer","Raymond","-","40","Navy",6500);
        p[8]=create("Shorts","Adidas","-","M","Black",1800);
        p[9]=create("Sweater","UCB","-","L","Green",2400);
        displayProducts(p, CYAN);
    }
    static void womenWear() {
    	Product[] p = new Product[10];
    	p[0]=create("Kurti","Biba","-","M","Pink",2300);
    	p[1]=create("Saree","Nalli","-","Free","Red",5200);
    	p[2]=create("Top","Zara","-","S","White",1800);
    	p[3]=create("Jeans","Levis","-","30","Blue",3200);
    	p[4]=create("Gown","Global Desi","-","M","Black",4800);
    	p[5]=create("Skirt","H&M","-","M","Green",2600);
    	p[6]=create("Leggings","Aurelia","-","Free","Black",1200);
    	p[7]=create("Jacket","Only","-","M","Grey",4200);
    	p[8]=create("Palazzo","W","-","L","Cream",2800);
    	p[9]=create("Tunic","FabIndia","-","M","Blue",3000);
    	displayProducts(p, BLUE);
    	}
    static void footwear() {
    	Product[] p = new Product[10];
    	p[0]=create("Running Shoes","Nike","-","9","Black",5500);
    	p[1]=create("Sneakers","Adidas","-","8","White",4800);
    	p[2]=create("Formal Shoes","Bata","-","9","Brown",4200);
    	p[3]=create("Sandals","Metro","-","7","Beige",2600);
    	p[4]=create("Heels","Catwalk","-","6","Red",3800);
    	p[5]=create("Loafers","Red Tape","-","9","Tan",4000);
    	p[6]=create("Flip Flops","Puma","-","8","Blue",1500);
    	p[7]=create("Boots","Woodland","-","9","Brown",6200);
    	p[8]=create("Sports Shoes","Reebok","-","8","Grey",5000);
    	p[9]=create("Slippers","Relaxo","-","7","Black",900);
    	displayProducts(p, BLUE);
    	}
    	static void accessories() {
    	Product[] p = new Product[10];
    	p[0]=create("Watch","Titan","-","-","Black",5500);
    	p[1]=create("Sunglasses","RayBan","-","-","Brown",4200);
    	p[2]=create("Wallet","Tommy Hilfiger","-","-","Black",2500);
    	p[3]=create("Belt","Levis","-","-","Brown",1800);
    	p[4]=create("Cap","Nike","-","-","Blue",1200);
    	p[5]=create("Bracelet","Fossil","-","-","Silver",3000);
    	p[6]=create("Necklace","Voylla","-","-","Gold",4800);
    	p[7]=create("Earrings","Zaveri Pearls","-","-","Gold",2200);
    	p[8]=create("Backpack","Skybags","-","30L","Grey",3500);
    	p[9]=create("Scarf","H&M","-","-","Red",1500);
    	displayProducts(p, BLUE);
    	}
    	static void pens() {
    	    Product[] pens = new Product[10];
    	    pens[0] = create("Ball Pen", "Cello", "-", "-", "Blue", 10);
    	    pens[1] = create("Gel Pen", "Reynolds", "-", "-", "Black", 15);
    	    pens[2] = create("Ink Pen", "Parker", "-", "-", "Black", 450);
    	    pens[3] = create("Fountain Pen", "Camlin", "-", "-", "Blue", 350);
    	    pens[4] = create("Marker Pen", "Camlin", "-", "-", "Red", 40);
    	    pens[5] = create("Sketch Pen", "DOMS", "-", "-", "Multicolor", 120);
    	    pens[6] = create("Highlighter", "Faber Castell", "-", "-", "Yellow", 60);
    	    pens[7] = create("Permanent Marker", "Sharpie", "-", "-", "Black", 90);
    	    pens[8] = create("Calligraphy Pen", "Manuscript", "-", "-", "Black", 550);
    	    pens[9] = create("Stylus Pen", "Portronics", "-", "-", "Silver", 699);
    	    displayProducts(pens, YELLOW);
    	}
    	static void notebooks() {
    	    Product[] notebooks = new Product[10];
    	    notebooks[0] = new Product("Classmate Long Notebook","Classmate","Notebook","300 Pages","-",90);
    	    notebooks[1] = new Product("Navneet Youva","Navneet","Notebook","200 Pages","-",80);
    	    notebooks[2] = new Product("Camlin Spiral Notebook","Camlin","Notebook","180 Pages","-",120);
    	    notebooks[3] = new Product("Paperkraft Executive","Paperkraft","Notebook","160 Pages","-",150);
    	    notebooks[4] = new Product("Scholar A4 Notebook","Scholar","Notebook","240 Pages","-",110);
    	    notebooks[5] = new Product("Oddy Ruled Notebook","Oddy","Notebook","200 Pages","-",70);
    	    notebooks[6] = new Product("Sundaram Record","Sundaram","Notebook","120 Pages","-",60);
    	    notebooks[7] = new Product("AmazonBasics A4 Paper","AmazonBasics","Paper","500 Sheets","-",320);
    	    notebooks[8] = new Product("JK Copier Paper","JK","Paper","500 Sheets","-",300);
    	    notebooks[9] = new Product("ITC Classmate Pulse","Classmate","Notebook","200 Pages","-",85);
    	    displayProducts(notebooks, YELLOW);
    	}
    	static void artAndCraft() {
    	    Product[] art = new Product[10];
    	    art[0] = new Product("Camlin Poster Colors","Camlin","Art","12 Shades","-",120);
    	    art[1] = new Product("Faber Castell Sketch Pens","Faber Castell","Art","24 Shades","-",250);
    	    art[2] = new Product("Brustro Acrylic Paints","Brustro","Art","12 Tubes","-",650);
    	    art[3] = new Product("Camel Oil Pastels","Camel","Art","25 Shades","-",180);
    	    art[4] = new Product("Kokuyo Origami Paper","Kokuyo","Art","100 Sheets","-",90);
    	    art[5] = new Product("Fevicol MR","Pidilite","Art","Adhesive","-",60);
    	    art[6] = new Product("Brustro Canvas Pad","Brustro","Art","10 Sheets","-",400);
    	    art[7] = new Product("Doms Colour Pencils","Doms","Art","24 Shades","-",170);
    	    art[8] = new Product("Camlin Water Colours","Camlin","Art","12 Shades","-",110);
    	    art[9] = new Product("Brustro Brush Set","Brustro","Art","7 Brushes","-",350);
    	    displayProducts(art, YELLOW);
    	}
    	static void officeSupplies() {
    	    Product[] office = new Product[10];
    	    office[0] = new Product("Kangaro Stapler","Kangaro","Office","Stapler","-",150);
    	    office[1] = new Product("Camlin Binder Clips","Camlin","Office","Clips Set","-",60);
    	    office[2] = new Product("Classmate Geometry Box","Classmate","Office","Math Kit","-",120);
    	    office[3] = new Product("Deli Paper Punch","Deli","Office","Puncher","-",180);
    	    office[4] = new Product("Oddy Glue Stick","Oddy","Office","Glue","-",25);
    	    office[5] = new Product("Scotch Tape","3M","Office","Tape","-",40);
    	    office[6] = new Product("Faber Castell Highlighter","Faber Castell","Office","Marker","-",90);
    	    office[7] = new Product("Camlin Whiteboard Marker","Camlin","Office","Marker","-",60);
    	    office[8] = new Product("AmazonBasics File Folder","AmazonBasics","Office","File","-",220);
    	    office[9] = new Product("Kokuyo Sticky Notes","Kokuyo","Office","Sticky Notes","-",80);
    	    displayProducts(office, YELLOW);
    	}
    	static void fruitsVegetables() {
    	    Product[] fv = new Product[10];

    	    fv[0] = create("Apple", "Fresh Farm", "-", "-", "Red", 180);
    	    fv[1] = create("Banana", "Local Farm", "-", "-", "Yellow", 60);
    	    fv[2] = create("Orange", "Nagpur Farm", "-", "-", "Orange", 90);
    	    fv[3] = create("Grapes", "Green Valley", "-", "-", "Green", 120);
    	    fv[4] = create("Mango", "Ratnagiri", "-", "-", "Yellow", 200);
    	    fv[5] = create("Tomato", "Organic Farm", "-", "-", "Red", 40);
    	    fv[6] = create("Potato", "Fresh Farm", "-", "-", "Brown", 35);
    	    fv[7] = create("Onion", "Local Market", "-", "-", "Pink", 50);
    	    fv[8] = create("Carrot", "Organic Farm", "-", "-", "Orange", 70);
    	    fv[9] = create("Cabbage", "Green Farm", "-", "-", "Green", 45);

    	    displayProducts(fv, WHITE);
    	}
    	static void beverages() {
    	    Product[] drinks = new Product[10];
    	    drinks[0] = new Product("Coca Cola","Coca Cola","Beverage","1.25 L","-",60);
    	    drinks[1] = new Product("Pepsi","Pepsi","Beverage","1.25 L","-",55);
    	    drinks[2] = new Product("Sprite","Sprite","Beverage","1.25 L","-",50);
    	    drinks[3] = new Product("Frooti Mango Drink","Frooti","Beverage","1 L","-",45);
    	    drinks[4] = new Product("Tropicana Orange Juice","Tropicana","Beverage","1 L","-",120);
    	    drinks[5] = new Product("Red Bull Energy Drink","Red Bull","Beverage","250 ml","-",150);
    	    drinks[6] = new Product("Minute Maid Pulpy","Minute Maid","Beverage","1 L","-",110);
    	    drinks[7] = new Product("Maaza Mango Drink","Maaza","Beverage","1 L","-",50);
    	    drinks[8] = new Product("Limca","Limca","Beverage","1.25 L","-",55);
    	    drinks[9] = new Product("Appy Fizz","Appy Fizz","Beverage","250 ml","-",60);
    	    displayProducts(drinks, WHITE);
    	}
    	static void snacks() {
    	    Product[] snks = new Product[10];
    	    snks[0] = new Product("Lays Classic","Lays","Snacks","70 gm","-",25);
    	    snks[1] = new Product("KurKure Masala Munch","KurKure","Snacks","70 gm","-",20);
    	    snks[2] = new Product("Bingo Mad Angles","Bingo","Snacks","60 gm","-",20);
    	    snks[3] = new Product("Uncle Chipps","Uncle Chipps","Snacks","60 gm","-",15);
    	    snks[4] = new Product("Haldiram Bhujia","Haldiram","Snacks","200 gm","-",90);
    	    snks[5] = new Product("Balaji Wafers","Balaji","Snacks","70 gm","-",25);
    	    snks[6] = new Product("Bingo Tomato Twist","Bingo","Snacks","60 gm","-",20);
    	    snks[7] = new Product("Kurkure Chilli Chatka","KurKure","Snacks","70 gm","-",20);
    	    snks[8] = new Product("Haldiram Aloo Bhujia","Haldiram","Snacks","200 gm","-",95);
    	    snks[9] = new Product("MTR Moong Dal","MTR","Snacks","150 gm","-",60);
    	    displayProducts(snks, WHITE);
    	}
    	static void staples() {
    	    Product[] stpls = new Product[10];
    	    stpls[0] = new Product("Aashirvaad Atta","Aashirvaad","Staple","5 Kg","-",420);
    	    stpls[1] = new Product("Fortune Sunflower Oil","Fortune","Staple","1 L","-",180);
    	    stpls[2] = new Product("Tata Salt","Tata","Staple","1 Kg","-",25);
    	    stpls[3] = new Product("Sundrop Oil","Sundrop","Staple","1 L","-",170);
    	    stpls[4] = new Product("India Gate Basmati Rice","India Gate","Staple","5 Kg","-",650);
    	    stpls[5] = new Product("Shan Masala","Shan","Staple","100 gm","-",60);
    	    stpls[6] = new Product("MDH Turmeric Powder","MDH","Staple","100 gm","-",50);
    	    stpls[7] = new Product("Tata Tea Premium","Tata","Staple","1 Kg","-",450);
    	    stpls[8] = new Product("Bru Instant Coffee","Bru","Staple","200 gm","-",180);
    	    stpls[9] = new Product("Fortune Rice Bran Oil","Fortune","Staple","1 L","-",200);
    	    displayProducts(stpls, WHITE);
    	}
    	static void displayProducts(Product[] arr) {
    	    for (int i = 0; i < arr.length; i++) {
    	        System.out.println((i + 1) + ". " + arr[i].name + " - ₹" + arr[i].price);
    	    }
    	}
}