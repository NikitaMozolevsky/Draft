package by.mozolevskij.pharmacy.example.lombok;


import lombok.*;

import java.io.*;
import java.net.URL;

@Getter
@Setter

/**STATIC FIELDS ARE IGNORED BY THESE ANNOTATIONS*/
@NoArgsConstructor /**generating a constructor without arguments*/
@AllArgsConstructor /**generating a constructor with all arguments*/
/**@RequiredArgsConstructor generating a constructor for each field*/
@ToString(includeFieldNames=true) /**"includeFieldNames = true" - The name of each field will be placed before it is value*/
                                  /**"onlyExplicitlyIncluded = true" - The fields which you want to include in toString()
                                   * included manually*/
@EqualsAndHashCode /**"onlyExplicitlyIncluded = true" - The fields which you want to include in hashCode() and equals()
                    * included manually*/
@Data /**@RequiredArgsConstructor (Constructor !!!ONLY FOR FINAL FIELDS!!!) + @Getter + @Setter + @ToString + @EqualsAndHashCode*/

/**@Value - It is a variant of a @Data annotation, makes all fields by default "private static"
          * Ignored setters(). Class marked as a "final"*/
public class Lombok {
    public static void main(String[] args) throws Exception {
        Lombok.someMethod();
    }

    @ToString.Include /**The lombok include field in toString()*/
    private int someField1;

    @ToString.Exclude /**The lombok ignored field in toString()*/
    @Setter(AccessLevel.PROTECTED) /**Changed access level*/
    private int someField2;

    @EqualsAndHashCode.Exclude
    private int someField3;

    @EqualsAndHashCode.Include
    private int someField4;

    private static void someMethod() throws Exception {
        URL inputResource = Lombok.class.getResource("input_text");
        URL outputResource = Lombok.class.getResource("output_text");
        /*Paths.get(resource.toURI()).toFile();*/
        @Cleanup /**Ensures that the resource will be cleaned automatically after completion (work as a TRY-WITH-RESOURCES)*/
        InputStream input = new FileInputStream("C:\\IdeaProjects\\untitled\\MAIN2\\src\\main\\java\\by\\mozolevskij\\pharmacy\\lombok\\input_text"); /**INPUT - ВХОД, FROM THIS FILE THERE IS A READING*/
        @Cleanup
        OutputStream output = new FileOutputStream("C:\\IdeaProjects\\untitled\\MAIN2\\src\\main\\java\\by\\mozolevskij\\pharmacy\\lombok\\output_text.txt"); /**OUTPUT - ВЫХОД, THIS FILE IS BEING WRITTEN TO
                                                                              (в этот файл  происходит запись)*/

        byte[] b = new byte[10000];

        while (true) {
            int r = input.read(b);

            if (r == -1)
                break;

            output.write(b, 0, r);
        }
    }
}
