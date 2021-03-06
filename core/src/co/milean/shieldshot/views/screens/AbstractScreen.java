package co.milean.shieldshot.views.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.me.geonauts.Geonauts;

/**
 * The base class for all game screens.
 */
public abstract class AbstractScreen implements Screen {	
    protected int ppuX;
    protected int ppuY;
	
    protected final Geonauts game;
    protected BitmapFont font;
    protected final SpriteBatch batch;
    protected final Stage stage;
    
    protected Table table;
    protected TextureRegionDrawable background;
    
    

    public AbstractScreen(Geonauts game ) {
        this.game = game;
        this.font = new BitmapFont();
        this.batch = new SpriteBatch();
        this.stage = new Stage( 0, 0, true );
        
		// Table
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		//table.debug(); // turn on all debug lines (table, cell, and widget)
	    //table.debugTable(); // turn on only table lines
		Texture texBackground = new Texture(Gdx.files.internal("images/backgrounds/mainmenu_720.png"));
		background = new TextureRegionDrawable(new TextureRegion(texBackground));
	    
    }

    protected String getName() {
        return getClass().getSimpleName();
    }

    // Screen implementation

	@Override
	public void resize(int width, int height) {
		stage.setViewport( width, height, false );
		
    	table.setSize(width, height);
    	table.clear();   
	}

    @Override
    public void render(float delta ) {
        // the following code clears the screen with the given RGB color (black)
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        // update and draw the stage actors
        stage.act( delta );
        stage.draw();
        //Table.drawDebug(stage);
    }

    @Override
    public void pause()
    {
       // Gdx.app.log( Tyrian.LOG, "Pausing screen: " + getName() );
    }

    @Override
    public void resume() {
       // Gdx.app.log( Tyrian.LOG, "Resuming screen: " + getName() );
    }

    @Override
    public void dispose()   {
      //  Gdx.app.log( Tyrian.LOG, "Disposing screen: " + getName() );

        // dispose the collaborators
        stage.dispose();
        batch.dispose();
        font.dispose();
    }
}
