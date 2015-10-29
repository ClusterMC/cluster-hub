package org.theclustermc.hub.utils.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

public class MongoDB {
	@Getter
	private MongoClient client;
	@Getter
	private MongoDatabase playerdata;
	
	private int port;
	private String host;
	private String database;
	private String user;
	private String password;
	
	public MongoDB(FileConfiguration file) {
		port = file.getInt("port");
		host = file.getString("host");
		database = file.getString("database");
		user = file.getString("user");
		password = file.getString("password");
	}
	
	public void open() {
		String path = "mongodb://" + user + ":" + password + "@" + host + ":" + port;
		client = new MongoClient(new MongoClientURI(path));
		playerdata = client.getDatabase(database);
	}
}
