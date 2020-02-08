package com.kas.mousetrap;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.kas.mousetrap.MouseTrap;
import com.kas.mousetrap.Screens.GameOverScreen;
import com.kas.mousetrap.Screens.GameScreen;
import com.kas.mousetrap.Screens.MainMenuScreen;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MouseTrap(), config);
		config.useImmersiveMode = false;
	}
}
