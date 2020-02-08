package com.kas.mousetrap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.kas.mousetrap.Screens.MainMenuScreen;

import java.util.Random;

public class MouseTrap extends ApplicationAdapter {
	private Texture bgpicture;
	private Array<Hexagon> hexarray = new Array<Hexagon>();
	private Array<Hexagon> touchable = new Array<Hexagon>();
	private TextureRegion MousePic;
	private MainMenuScreen mainscreen;
	int oldx=0;
	int oldy=0;
	private int level,levelbricks;
	//Vector3 touch = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
	SpriteBatch batch;
	Texture img;

	public void clear_side(Array<Hexagon> hexarray){
		for(int i=0;i<hexarray.size;i++){
			if(i<15){
				hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,hexarray.get(i).brick,hexarray.get(i).choosed,
						hexarray.get(i).east,hexarray.get(i).west,hexarray.get(i).northeast,hexarray.get(i).northwest,999,999)));
			}
			if(i==0 && i==30 && i==60 && i==90 && i==120 && i==150){
				hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,hexarray.get(i).brick,hexarray.get(i).choosed,
						hexarray.get(i).east,999,hexarray.get(i).northeast,999,999,hexarray.get(i).southeast)));
			}
			if(i==15 && i==45 && i==75 && i==105 && i==135){
				hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,hexarray.get(i).brick,hexarray.get(i).choosed,
						hexarray.get(i).east,999,hexarray.get(i).northeast,hexarray.get(i).northwest,hexarray.get(i).southwest,hexarray.get(i).southeast)));
			}
			if(i>149 && i<165){
				hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,hexarray.get(i).brick,hexarray.get(i).choosed,
						hexarray.get(i).east,hexarray.get(i).west,999,999,hexarray.get(i).southwest,hexarray.get(i).southeast)));
			}
			if(i==14 && i==44 && i==74 && i==104 && i==134 && i==164){
				hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,hexarray.get(i).brick,hexarray.get(i).choosed,
						999,hexarray.get(i).west,hexarray.get(i).northeast,hexarray.get(i).northwest,hexarray.get(i).southwest,hexarray.get(i).southeast)));
			}
			if(i==29 && i==59 && i==89 && i==119 && i==149){
				hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,hexarray.get(i).brick,hexarray.get(i).choosed,
						999,hexarray.get(i).west,999,hexarray.get(i).northwest,hexarray.get(i).southwest,999)));
			}
		}
	}
	
	@Override

	public void create () {

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		bgpicture = new Texture("background.jpg");
		MousePic = new TextureRegion(new Texture("mouse.png"));
		mainscreen = new MainMenuScreen();
		Random r = new Random();
		level = 1;
		levelbricks= level*3;
		for(int i=0;i<11;i++){
			for(int j=0;j<15;j++){
				int id = j+(i*15);
				if(i%2 == 0){
					hexarray.add(new Hexagon(id,270+(j*90),40+(i*85),false,false,
							id+1,id-1,id+15,id+14,id-16,id-15));
				}
				else{
					hexarray.add(new Hexagon(id,(270+45)+(j*90),40+(i*85),false,false,
							id+1,id-1,id+16,id+15,id-15,id-14));
				}
			}
		}
		for(int i=0;i<levelbricks;i++)
		{
			int a = r.nextInt(165);
			hexarray.set(a,(new Hexagon(hexarray.get(a).hex_id,(int)hexarray.get(a).position.x,(int)hexarray.get(a).position.y,true,hexarray.get(a).choosed,
					hexarray.get(a).east,hexarray.get(a).west,hexarray.get(a).northeast,hexarray.get(a).northwest,hexarray.get(a).southwest,hexarray.get(a).southeast)));
		}
		clear_side(hexarray);
		for(int i=0;i<11;i++){
			for(int j=0;j<15;j++){
				if(i%2 == 0){
					touchable.add(new Hexagon(305+(j*90),375+(j*90),943-(i*85),991-(i*85)));
				}
				else{
					touchable.add(new Hexagon(352+(j*90),422+(j*90),943-(i*85),991-(i*85)));
				}
			}
		}


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(bgpicture,0,0);
		for(Hexagon hexagon:hexarray)
			batch.draw(hexagon.picture, hexagon.position.x, hexagon.position.y);

		//if(Gdx.input.justTouched()){
		//	System.out.println(Gdx.input.getX());
		//	System.out.println(Gdx.input.getY());
		//}

		//for (int i=0;i<hexarray.size;i++){
		//	batch.draw(MousePic,hexarray.get(i).MousePosition.x,hexarray.get(i).MousePosition.y);

		//}
		batch.draw(MousePic,hexarray.get(82).MousePosition.x,hexarray.get(82).MousePosition.y);
		//System.out.println(hexarray.size);

		int tX = Gdx.input.getX();
		int tY = Gdx.input.getY();
		int i=0;

		if((oldx != tX || oldy != tY)){
			//controlling previous touch point same
			oldx = tX;
			oldy = tY;

			for(Hexagon hexagon:touchable){

				//if touched any hexagon touchable point
				if(hexagon.touchPosition1.x < tX && hexagon.touchPosition2.x > tX && hexagon.touchPosition1.y < tY && hexagon.touchPosition2.y > tY){

					//if this hexagon no brick and no choosed
					if(hexarray.get(i).brick == false && hexarray.get(i).choosed == false){

						for(int j=0;j<hexarray.size;j++){
							if(hexarray.get(j).choosed == true)
								{
									hexarray.set(j,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(j).position.x,(int)hexarray.get(j).position.y,false,false,
										hexarray.get(i).east,hexarray.get(i).west,hexarray.get(i).northeast,hexarray.get(i).northwest,hexarray.get(i).southwest,hexarray.get(i).southeast)));
								}

						}
						hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,false,true,
								hexarray.get(i).east,hexarray.get(i).west,hexarray.get(i).northeast,hexarray.get(i).northwest,hexarray.get(i).southwest,hexarray.get(i).southeast)));
					}

					//if this hexagon no brick and choosed
					else if(hexarray.get(i).brick == false && hexarray.get(i).choosed == true) {
						hexarray.set(i,(new Hexagon(hexarray.get(i).hex_id,(int)hexarray.get(i).position.x,(int)hexarray.get(i).position.y,true,false,
								hexarray.get(i).east,hexarray.get(i).west,hexarray.get(i).northeast,hexarray.get(i).northwest,hexarray.get(i).southwest,hexarray.get(i).southeast)));
					}
					break;
				}
				i++;
			}

		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

}
