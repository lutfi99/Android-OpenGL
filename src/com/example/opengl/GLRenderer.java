package com.example.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.Log;

public class GLRenderer implements GLSurfaceView.Renderer {
	
	private static final String TAG = "GLRenderer";
	private final Context context;
	private final GLCube cube = new GLCube();
	
	GLRenderer(Context context) {
		this.context = context;
	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
	
		//cahaya
		float lightAmbient[] = new float[] { 0.2f, 0.2f, 0.2f, 1 };
	    float lightDiffuse[] = new float[] { 1, 1, 1, 1 };
	    float[] lightPos = new float[] { 1, 1, 1, 1 };
	      gl.glEnable(GL10.GL_LIGHTING);
	      gl.glEnable(GL10.GL_LIGHT0);
	      gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, lightAmbient, 0);
	      gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, lightDiffuse, 0);
	      gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPos, 0);
	    
	      //cahaya cube
	      float matAmbient[] = new float[] { 1, 1, 1, 1 };
	      float matDiffuse[] = new float[] { 1, 1, 1, 1 };
	      gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT,
	            matAmbient, 0);
	      gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE,
	            matDiffuse, 0);
	      
	      //setup openGL
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		

	}
	
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		float ratio = (float) width / height;
		GLU.gluPerspective(gl, 45.0f, ratio, 1, 100f);
	}
	
	public void onDrawFrame(GL10 gl) {
		//clear the screen to black
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		//posisi objek
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glTranslatef(0, 0, -3.0f);
		
		//draw the model
		cube.draw(gl);
	}

}
