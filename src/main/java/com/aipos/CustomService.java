package com.aipos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomService {
    public List<String> getFilesName()
    {   List namefile = new ArrayList();

        File file = new File("D:\\students");
        File files[] = file.listFiles();
        for (File file1:files)
        {
            namefile.add(file1.getName());
        }

        return namefile;
    }
    public void createStudent(String name/*, String surname, String group,String facultet, String srbal, String nubmer*/){
        File file = new File("D:\\students\\"+name + ".txt");
        try
        {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            // пишем данные
            bw.write("Name: " + name + "\n");
          /*  bw.write("Family: " + surname + "\n");
            bw.write("Group: " + group + "\n");
            bw.write("Facult: " + facultet + "\n");
            bw.write("Sr.Bal: " + srbal + "\n");
            bw.write("Tel.Number: " + nubmer + "\n");*/


            // закрываем поток
            bw.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public String readFile(String filenames) {

        try ( BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("D:\\students\\"+filenames), "UTF8"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            String everything = sb.toString();

            return everything;

        } catch (IOException io) {

            return "Файл не найден";
        }




    }
}
