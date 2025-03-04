import static org.lwjgl.opengl.GL40.*;

import graphics.core.*;

public class Test_2_3 extends Base
{
    public int programRef;

    public void initialize()
    {
        // load code, send to GPU, and compile; store program reference
        programRef = OpenGLUtils.initFromFiles(
            "Test_2_3.vert", "Test_2_3.frag" );

        // render settings (optional)

        // set line width
        glLineWidth(4);

        int vaoRef = glGenVertexArrays();
        glBindVertexArray(vaoRef);

        float[] positionData = {
                 0.8f,  0.0f, 0.0f,
                 0.4f,  0.6f, 0.0f,
                -0.4f,  0.6f, 0.0f,
                -0.8f,  0.0f, 0.0f,
                -0.4f, -0.6f, 0.0f,
                 0.4f, -0.6f, 0.0f  };
        Attribute positionAttribute = new Attribute( "vec3", positionData );
        positionAttribute.associateVariable( programRef, "position" );
    }

    public void update()
    {
        // select program to use when rendering
        glUseProgram( programRef );

        // render geometric objects using selected program
        glDrawArrays(GL_LINE_LOOP, 0, 6);
    }

    // driver method
    public static void main(String[] args)
    {
        new Test_2_3().run();
    }

}
