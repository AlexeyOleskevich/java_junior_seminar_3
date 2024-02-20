package task3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Alex", 18, 7.2);

        System.out.println(student);
        System.out.println();
        try (FileOutputStream out = new FileOutputStream("student.bin");
             ObjectOutputStream outputStream = new ObjectOutputStream(out)) {
            outputStream.writeObject(student);
        }

        try(FileInputStream in = new FileInputStream("student.bin");
            ObjectInputStream inputStream = new ObjectInputStream(in)) {
            student = (Student)inputStream.readObject();
        }

        System.out.println(student);
    }
}
