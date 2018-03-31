package view;

import com.aipos.CustomService;

public class Lol {
    public static void main(String[] args) {
        CustomService customService = new CustomService();
        System.out.println(customService.readFile("pasha"));
    }
}
