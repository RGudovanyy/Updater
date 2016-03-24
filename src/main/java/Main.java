import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static String PATH = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+"/";
    //public static String PATH = "/home/anvi/files/";
    public static void main(String[] args) {

        System.out.println("Текущий путь для сохранения: " + PATH);
        List<String> localListNames = new ArrayList<String>();
        List<String> remoteListPaths = new ArrayList<String>();
        File dir = new File(PATH);
        if(dir.isDirectory()){
            for(String s : dir.list())
                localListNames.add(s);
        }
        File configFile;
        boolean isNewFile = false;
        try {
            configFile = new File("conf.txt");
            if(!configFile.exists()) {
                System.out.println("Не найден файл conf, создаем новый...\nНе забудьте добавить в него пути к нужным файлам!");
                configFile.createNewFile();
                isNewFile = true;
            }
            remoteListPaths = new ConfigReader().read(configFile);
        }
        catch (IOException e) {
            System.out.println("Возникла ошибка ввода-вывода");
        }
        for(String name : localListNames)
            new Verifyer().versionCheck(name,remoteListPaths);
        if(!isNewFile)
            System.out.println("\nВсе файлы обновлены".trim());
        System.out.println("Press Enter key to exit...");
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine() == "")
            System.exit(0);

    }


}
