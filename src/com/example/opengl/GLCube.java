package com.example.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLCube {
	
	private final IntBuffer mVertexBuffer;
	
	public GLCube() {
		int one = 65536;
		int half = one/2;
		int vertices[] = {
				// FRONT
	            -half, -half, half, half, -half, half,
	            -half, half, half, half, half, half,
	            // BACK
	            -half, -half, -half, -half, half, -half,
	            half, -half, -half, half, half, -half,
	            // LEFT
	            -half, -half, half, -half, half, half,
	            -half, -half, -half, -half, half, -half,
	            // RIGHT
	            half, -half, -half, half, half, -half,
	            half, -half, half, half, half, half,
	            // TOP
	            -half, half, half, half, half, half,
	            -half, half, -half, half, half, -half,
	            // BOTTOM
	            -half, -half, half, -half, -half, -half,
	            half, -half, half, half, -half, -half,
		};
		
		int texCoords[] = {
	            // FRONT
	            0, one, one, one, 0, 0, one, 0,
	            // BACK
	            one, one, one, 0, 0, one, 0, 0,
	            // LEFT
	            one, one, one, 0, 0, one, 0, 0,
	            // RIGHT
	            one, one, one, 0, 0, one, 0, 0,
	            // TOP
	            one, 0, 0, 0, one, one, 0, one,
	            // BOTTOM
	            0, 0, 0, one, one, 0, one, one, };
	      
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
		vbb.order(ByteOrder.nativeOrder());
		mVertexBuffer = vbb.asIntBuffer();
		mVertexBuffer.put(vertices);
		mVertexBuffer.position(0);
	}
		
		public void draw(GL10 gl) {
			  gl.glVertexPointer(3, GL10.GL_FIXED, 0, mVertexBuffer);
		      
		      gl.glColor4f(1, 1, 1, 1);
		      gl.glNormal3f(0, 0, 1);
		      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
		      gl.glNormal3f(0, 0, -1);
		      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4);

		      gl.glColor4f(1, 1, 1, 1);
		      gl.glNormal3f(-1, 0, 0);
		      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);
		      gl.glNormal3f(1, 0, 0);
		      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);

		      gl.glColor4f(1, 1, 1, 1);
		      gl.glNormal3f(0, 1, 0);
		      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);
		      gl.glNormal3f(0, -1, 0);
		      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4);
		}

}
