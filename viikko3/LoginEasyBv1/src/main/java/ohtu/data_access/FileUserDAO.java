package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ohtu.domain.User;

public class FileUserDAO implements UserDao {
	
	private String fileLocation;
	
	public FileUserDAO(String fileLocation) throws FileNotFoundException {
		this.fileLocation = fileLocation;
	}
	
	private File getFile() throws IOException {
		File file = new File(fileLocation);
		file.createNewFile();
		return file;
	}
	
	private Scanner openFileScanner() throws IOException {
		return new Scanner(getFile());
	}
	
	private User parseUser(String user) {
		int markerPos = user.indexOf(" : ");
		String username = user.substring(0, markerPos);
		String password = user.substring(markerPos + 3);
		return new User(username, password);
	}

	@Override
	public List<User> listAll() {
		List<User> users = new ArrayList<User>();
		try {
			Scanner scanner = openFileScanner();
			while (scanner.hasNextLine()) {
				users.add(parseUser(scanner.nextLine()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findByName(String name) {
		try {
			Scanner scanner = openFileScanner();
			while (scanner.hasNextLine()) {
				User user = parseUser(scanner.nextLine());
				if (user.getUsername().equals(name)) {
					return user;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(User user) {
		try {
			PrintWriter writer = new PrintWriter(getFile());
			writer.println(user.getUsername() + " : " + user.getPassword());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
