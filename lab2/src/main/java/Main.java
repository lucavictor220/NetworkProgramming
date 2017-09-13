import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.io.*;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Created by vitiok on 8/29/17.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        //  >>>>> Task 1 START <<<<<<<<

        CharSequence string1 = "something";
        CharSequence string2 = "newstring";

        int result = StringUtils.getLevenshteinDistance(string1, string2);

        System.out.println("TASK 1 +++++++");
        System.out.println(result);
        System.out.println("TASK 1 +++++++");

        //  >>>>> Task 1 END <<<<<<<<

        //  >>>>> Task 2 START <<<<<<<<

        final Random random = new Random();

        RandomNumbersVector randomVectorNumberGenerator = new RandomNumbersVector(1000);

        System.out.println("TASK 2 -------------------");

        VectorPrettyPrint vectorPrettyPrint = new VectorPrettyPrint();
        vectorPrettyPrint.print(randomVectorNumberGenerator.nextVector());
        System.out.println("TASK 2 -------------------");

        //  >>>>> Task 2 END <<<<<<<<

        //  >>>>> Task 3 START <<<<<<<<

        SummaryStatistics summaryStatistics = new SummaryStatistics();

        Random rand = new Random();
        int randomValuesNr = 100;

        for (int i = 0; i < randomValuesNr; ++i) {
            summaryStatistics.addValue(rand.nextInt(100));
        }

        System.out.println("TASK 3 -------------------");
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getGeometricMean());
        System.out.println("TASK 3 -------------------");

        //  >>>>> Task 3 END <<<<<<<<

        //  >>>>> Task 4 START <<<<<<<<


        System.out.println("TASK 4 -------------------");
        byte[] buffer = new byte[1024];

        try {

            FileOutputStream fileOutputStream = new FileOutputStream("myfile.zip");
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            ZipEntry zipEntry = new ZipEntry("file.txt");
            zipOutputStream.putNextEntry(zipEntry);
            FileInputStream fileInputStream = new FileInputStream("file.txt");

            int len;
            while ((len = fileInputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }

            fileInputStream.close();
            zipOutputStream.closeEntry();

            zipOutputStream.close();

            System.out.println("Done");

        } catch(IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("TASK 4 -------------------");

        //  >>>>> Task 4 END <<<<<<<<
    }

}
