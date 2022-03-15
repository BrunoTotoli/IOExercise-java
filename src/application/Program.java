package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList();
        String pathWriter = "C:\\Users\\Bruno\\IdeaProjects\\course3exercise\\file.csv";
        String pathReadAndWrite = "C:\\Users\\Bruno\\IdeaProjects\\course3exercise\\otherfolder";

        write(sc, list, pathWriter);
        read(pathWriter);
        outSummary(list, pathReadAndWrite);


    }

    static void write(Scanner sc, List<Product> list, String pathWriter) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter, true))) {
            String input = sc.nextLine();
            String inputSplit[] = input.split(",");
            Product product = new Product(inputSplit[0], Double.valueOf(inputSplit[1]), Integer.valueOf(inputSplit[2]));
            list.add(product);
            bw.write(product.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void read(String pathWriter) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathWriter))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void outSummary(List<Product> products, String pathWriter) {
        boolean isCreate = new File(pathWriter).mkdir();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathWriter + "\\summary.csv", true))) {
            for (Product product : products) {
                bw.write(product.getName() + "," +String.format("%.2f",product.getTotal()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
