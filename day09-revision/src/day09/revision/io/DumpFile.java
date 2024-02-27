package day09.revision.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.processing.FilerException;

public class DumpFile {

   private final String fileName;

   public DumpFile(String fn) {
      this.fileName = fn;
   }

   public void printLines() {
      try (FileReader fr = new FileReader(fileName)) {
         BufferedReader br = new BufferedReader(fr);
         /*
         String line;
         while ((line = br.readLine()) != null) {
            if (line.trim().length() <= 0)
               continue;
            System.out.printf(">>>> %s\n", line);
         }
         */

         br.lines()
            .forEach(line -> {
               System.out.printf("stream: %s\n", line);
            });
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }
   
}
