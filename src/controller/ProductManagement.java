/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Product;
import model.Producer;
import view.Menu;

/**
 *
 * @author admin
 */
public class ProductManagement extends Menu {

    List<Product> arr = new ArrayList<>();
    private Producer producer;

    public ProductManagement(String title, String[] s) {
        super(title, s);
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> {
                Producer.readFromFile("product.txt", arr);
                Producer.PrintAnyListOfProduct((ArrayList<Product>) arr);
                break;
            }
            case 2 -> {
                Producer.addProduct(arr);
                break;
            }
            case 3 -> {
                SearchProduct2(arr);
                break;
            }

            case 4 -> {
                Producer.WriteToFile(arr, "products.txt");
                break;
            }

            case 5 -> {
                System.out.println("--------Exit--------");
                return;
            }
            default -> {
                System.out.println("Error,Invalid choice(0<choice<=5)");
                System.out.println("-----------------------");
                System.out.println("");
            }
        }
    }

    public static void SearchProduct1(List<Product> arr) {
        Scanner sc = new Scanner(System.in);
        String title = "\n------------------------\nMenu Search";
        String[] s = new String[]{"By id",
            "By Name",
            "By date",
            "Exit"};
        Menu mn = new Menu(title, s) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Input product id to search: ");
                        String SearchId = sc.nextLine();
                        Producer.SearchById(arr, SearchId);
                        break;
                    }
                    case 2 -> {
                        System.out.println("Input product name to search: ");
                        String SearchName = sc.nextLine();
                        Producer.SearchByName(arr, SearchName);
                        break;
                    }
                    case 3 -> {
                        System.out.println("Input product date to search: ");
                        String SearchDate = sc.nextLine();
                        Producer.SearchByDate(arr, SearchDate);
                        break;
                    }
                    case 4 -> {
                        System.out.println("--------Exit--------");
                        return;
                    }
                  
                }
            }
        };
        mn.run();
    }
    
    public static void SearchProduct2(List<Product> arr) {
        Scanner sc = new Scanner(System.in);
        String title = "\n------------------------\nMenu Search";
        String[] s = new String[]{"By id",
            "By Name",
            "By date",
            "Exit"};
        Menu mn = new Menu(title, s) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Input product id to search: ");
                        String SearchId = sc.nextLine();
                        Producer.SearchByCondition(arr, new Predicate<Product>(){
                            @Override
                            public boolean test(Product t){
                                return t.getProductID().equals(SearchId);
                            }
                        });
                        break;
                    }
                    case 2 -> {
                        System.out.println("Input product name to search: ");
                        String SearchName = sc.nextLine();
                        Producer.SearchByCondition(arr, (Product t) -> t.getproductName().equals(SearchName));
                        break;
                    }
                    case 3 -> {
                        System.out.println("Input product date to search: ");
                        String SearchDate = sc.nextLine();
                        Producer.SearchByCondition(arr, (Product t) -> t.getProductManufacturingDate().equals(SearchDate));
                        break;
                    }
                    case 4 -> {
                        System.out.println("--------Exit--------");
                        return;
                    }
                  
                }
            }
        };
        mn.run();
    }

    public static void main(String[] args) {
        String title = "\n------------------------\nProduct Management";
        String[] s = new String[]{"List products from file",
            "Add product",
            "Search product",
            "Write to file",
            "Exit"};
        ProductManagement menu = new ProductManagement(title, s);
        menu.run();
    }

}
