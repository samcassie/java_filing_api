package com.codeclan.example.filing.components;

import com.codeclan.example.filing.models.File;
import com.codeclan.example.filing.models.Folder;
import com.codeclan.example.filing.models.User;
import com.codeclan.example.filing.repository.FileRepository;
import com.codeclan.example.filing.repository.FolderRepository;
import com.codeclan.example.filing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) {

        User user1 = new User("Sam");
        userRepository.save(user1);

        User user2 = new User("Adam");
        userRepository.save(user2);

        Folder folder1 = new Folder("Job Stuff", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Bants", user1);
        folderRepository.save(folder2);

        File file1 = new File("My CV", "txt", 10, folder1);
        fileRepository.save(file1);

        File file2 = new File("Cover Letter", "txt", 8, folder1);
        fileRepository.save(file2);

        File file3 = new File("Funny Stuff", "jpg", 15, folder2);
        fileRepository.save(file3);

    }
}
