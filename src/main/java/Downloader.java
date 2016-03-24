import java.io.*;

public class Downloader {
    //public static String PATH = "/home/anvi/files/";
    public static String PATH = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+"/";
    public void download(File file, String oldName){
        File destF = new File(PATH + oldName);
        InputStream source = null;
        OutputStream destination = null;
        try{
            source = new FileInputStream(file);
            destination = new FileOutputStream(destF);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = source.read(buffer)) > 0) {
                System.out.print(".");
                destination.write(buffer, 0, length);
            }
            File newName = new File(PATH + file.getName());
            destF.renameTo(newName);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл для копирования");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(source!=null)
                try {
                    source.close();
                } catch (IOException e) {
                }
            if (destination !=null)
                try {
                    destination.close();
                } catch (IOException e) {
                }
        }
    }
}
