package co.milean.shieldshot;

import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.geonauts.screens.GameScreen;
import com.me.geonauts.screens.ui.MainMenuScreen;

public class ShieldShot extends Game {
	SpriteBatch batch;
	Texture img;
	
	public Random randomGen = new Random();
	private GameScreen gameScreen;
	private MainMenuScreen mainMenu;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		
		// Create all the screens
		gameScreen = new GameScreen(this);
		mainMenu = new MainMenuScreen(this);

		// AUDIO
		//oggShop = Gdx.audio.newSound(Gdx.files.internal("audio/shop_music.ogg"));
		//shopMusicOgg = Gdx.audio.newMusic(Gdx.files.internal("audio/shop_music.ogg"));
		//shopMusicOgg.setLooping(true);
		
		setScreen(mainMenu);	
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	
	
	// SET SCREEN METHOD IS EXTENDED BY GAME
}
