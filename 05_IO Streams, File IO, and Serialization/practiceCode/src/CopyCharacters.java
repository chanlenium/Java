import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        if(args.length < 2)
            return;

        /** Character based stream that convert stream in background.
         * It convert Byte information to Character information
         * and manipulate it in the background
         * Class names of character based stream end with Reader and Writer
         */
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try{
            inputStream = new FileReader(args[0]);
            outputStream = new FileWriter(args[1]);
            int c;

            // read input by 1 character unit and return int value
            // character로 구성된 txt파일을 read/write하면 read와 동일한 write(output)파일 생성
            // 그러나, byte정보로 구성된 파일(일례로, jpg)을 read/write하면 read파일과는 다른 깨진 파일이 생성됨
            while((c = inputStream.read()) != -1)
                outputStream.write(c);
        }finally {
            if(inputStream != null)
                inputStream.close();
            if(outputStream != null)
                outputStream.close();
        }
    }
}
