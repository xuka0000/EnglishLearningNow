import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 使用线程播放音乐文件的工具类
 * 不需要关注如何实现，只需要关注如何使用本类来播放音乐即可
 * @author 窖头
 *
 */
public class AudioPlayer extends Thread{
	Player player;
	File musicFile;
	
	public AudioPlayer(File file) {
		if(null == file || !file.exists()) {
			throw new RuntimeException("音乐文件不存在，无法播放！");
		}
		this.musicFile = file;
		
	}
	
	public AudioPlayer(String filePath) {
		this(new File(filePath));
	}

	public void runBg() {
		try {
			play();
			sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			play();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stopMusic() {
		player.close();
	}
	
	public void play() throws FileNotFoundException, JavaLayerException {
		BufferedInputStream instream = new BufferedInputStream(new FileInputStream(musicFile));
		player = new Player(instream);
		
		player.play();
	}
}
