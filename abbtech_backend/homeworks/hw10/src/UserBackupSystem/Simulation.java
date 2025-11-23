package UserBackupSystem;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        List<User> users = List.of(
                new User("Sandman","sss@gmail.com",25),
                new User("Grinch","aaa@gmail.com", 24),
                new User("Truck","ggg@gmail.com",27)
                );
        String source = "src/UserBapSystem/objects.ser";
        String backup = "src/UserBackupSystem/backup.ser";

        try {
            UserBackupService userBackupService = new UserBackupService();
            userBackupService.checkIfPathExists(source);
            userBackupService.checkIfPathExists(backup);
            userBackupService.saveUsers(users, source);
            userBackupService.loadUsers(source);
            userBackupService.saveUsers(users, source);
            userBackupService.loadUsers(source);
            userBackupService.backupFile(source, backup);
            userBackupService.deleteBackup(backup);
        }catch(IOException |ClassNotFoundException |PathNotFoundException e){
            System.out.println("Something went wrong... \n" + e.getMessage());
        }
    }
}
