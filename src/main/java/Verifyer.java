import java.io.File;
import java.util.List;

public class Verifyer {
    public static String PATH = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()+"/";
    //public static String PATH = "/home/anvi/files/";
    public void versionCheck(String localName, List<String> remote) {
        for(String remoteName : remote){
            File localFile = new File(PATH+localName);
            File remoteFile = new File(remoteName);
            String regEx = "[0123456789,.-]";
            String remoteSplitName = remoteFile.getName().split(regEx)[0];
            String localSplitName = localFile.getName().split(regEx)[0];
            if(remoteSplitName.equals(localSplitName)){
                if(localFile.lastModified() < remoteFile.lastModified()) {
                    System.out.println("Найдена новая версия " + localSplitName);
                    new Downloader().download(remoteFile, localName);
                    System.out.println("\nНовая версия " + localSplitName + " скопирована");
                }
            }
        }
    }
}
