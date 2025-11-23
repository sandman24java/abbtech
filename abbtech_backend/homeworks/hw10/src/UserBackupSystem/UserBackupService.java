package UserBackupSystem;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UserBackupService  {
    public void saveUsers(List<User> users, String filepath) throws IOException {
        Path file_path = new File(filepath).toPath();
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file_path))){
            oos.writeObject(users);
        }
    }
    public void loadUsers(String filepath) throws IOException, ClassNotFoundException {
        Path file_path = Paths.get(filepath);
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file_path))){
            List<User> read_object =(List<User>)ois.readObject();
            System.out.println("Loaded users from file:");;
            read_object.stream().forEach(System.out::println);
    }
    }
    public void  backupFile(String source, String backup) throws IOException {
        Path file_path_source = Paths.get(source);
        Path file_path_backup = Paths.get(backup);
        Files.copy(file_path_source,file_path_backup);
        System.out.println("Backup file has been saved to: "+file_path_backup);
    }
    public void deleteBackup(String backupFilePath)  {
        File file_to_delete = new File(backupFilePath);
        if (file_to_delete.exists()) {
            file_to_delete.delete();
            System.out.println("Backup file has been deleted from: "+file_to_delete);
        }
    }
    public void checkIfPathExists(String path){
        if (!Files.exists(Paths.get(path))){
            throw new PathNotFoundException("Your path does not exist");
        }
    }
}
