package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Producer {

    List<Product> products = new ArrayList<>();

    public Producer() {
        products = new ArrayList<>();
    }

    public Producer(List<Product> products) {
        this.products = products;
    }

    public static void readFromFile(String filename, List<Product> arr) {
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String Line = sc.nextLine();
                String[] s = Line.split(", ");

                String Id = s[0].split("=")[1].trim();
                String Name = s[1].split("=")[1].trim();
                double UnitPrice = Double.parseDouble(s[2].split("=")[1].trim());
                int Quantity = Integer.parseInt(s[3].split("=")[1].trim());
                double Version = Double.parseDouble(s[4].split("=")[1].trim());
                String ProductManufacturingDate = s[5].split("=")[1].trim();

                Product p = new Product(Id, Name, UnitPrice, Quantity, Version, ProductManufacturingDate);

                arr.add(p);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static void WriteToFile(List<Product> arr, String filename) throws IOException {
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f, false);
            PrintWriter pw = new PrintWriter(fw);
            
            for(int i=0; i<=arr.size();i++){
                pw.append(arr.get(i).toString()+"\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void addProduct(List<Product> arr) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input product id: ");
        String ProductID = sc.nextLine();
        System.out.println("Input product name: ");
        String ProductName = sc.nextLine();
        System.out.println("Input unit price: ");
        double UnitPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Input quantity: ");
        int Quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Input version: ");
        int Version = Integer.parseInt(sc.nextLine());
        System.out.println("Input product manufacturing date: ");
        String ProductManufacturingDate = sc.nextLine();

        Product p = new Product(ProductID, ProductName, UnitPrice, Quantity, UnitPrice, ProductManufacturingDate);
        arr.add(p);
    }

    public static void SearchById(List<Product> arr, String idProduct) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getProductID().equals(idProduct)) {
                System.out.println(arr.get(i).toString());
            }
        }
    }

    public static void SearchByName(List<Product> arr, String nameProduct) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getproductName().equals(nameProduct)) {
                System.out.println(arr.get(i).toString());
            }
        }
    }

    public static void SearchByDate(List<Product> arr, String dateProduct) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getProductManufacturingDate().equals(dateProduct)) {
                System.out.println(arr.get(i).toString());
            }
        }
    }

    public static void SearchByCondition(List<Product> arr, Predicate<Product> p) {
        for (int i = 0; i < arr.size(); i++) {
            if (p.test(arr.get(i))) {
                System.out.println(arr.get(i).toString());
            }
        }
    }

    public static void PrintAnyListOfProduct(ArrayList<Product> arr) {
        for (Product product : arr) {
            System.out.println(product);
        }
    }

//     public static void AddNewProduct(ArrayList<Product> arr){
//        scab
//     }
}
