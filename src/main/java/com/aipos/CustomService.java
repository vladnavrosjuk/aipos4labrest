package com.aipos;

import com.aipos.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomService {
    public List<String> getFilesName()
    {   List namefile = new ArrayList();

        File file = new File("D:\\aipos4lab");
        File files[] = file.listFiles();
        for (File file1:files)
        {
            namefile.add(file1.getName());
        }

        return namefile;
    }

    public void createStudent(Student student){
        File file = new File("D:\\aipos4lab\\"+student.getName() + ".txt");
        try
        {
            // открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            // пишем данные
            bw.write("Name: " + student.getName() + "\n");
            bw.write("Family: " + student.getSurname() + "\n");
            bw.write("Group: " + student.getGroup() + "\n");
            bw.write("Facult: " + student.getUniver().getFacultet().getName() + "\n");
            bw.write("Spec: " + student.getUniver().getFacultet().getSpec() + "\n");
            bw.write("Univer: " + student.getUniver().getName()+ "\n");
            bw.write("Sphere: " + student.getUniver().getSphere() + "\n");
            bw.write("Sr.Bal: " + student.getAvscore() + "\n");
            bw.write("Tel.Number: " + student.getNumber() + "\n");


            // закрываем поток
            bw.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void deletefile(String filename){
        File file = new File("D:\\aipos4lab\\"+filename);
        file.delete();
    }
    public String readFile(String filenames) {

        try ( BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("D:\\aipos4lab\\"+filenames), "UTF8"))) {
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
