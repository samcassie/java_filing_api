package com.codeclan.example.filing;

import com.codeclan.example.filing.models.File;
import com.codeclan.example.filing.models.Folder;
import com.codeclan.example.filing.models.User;
import com.codeclan.example.filing.repository.FileRepository;
import com.codeclan.example.filing.repository.FolderRepository;
import com.codeclan.example.filing.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class FilingApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createFileFolderUser(){

		User user1 = new User("Sam");
		userRepository.save(user1);

		Folder folder1 = new Folder("Job Stuff", user1);
		folderRepository.save(folder1);

		File file1 = new File("My CV", "txt", 10, folder1);
		fileRepository.save(file1);

		File file2 = new File("Cover Letter", "txt", 8, folder1);
		fileRepository.save(file2);
	}

}
