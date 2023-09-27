#version 400 core

//in vec3 colour;
in vec2 pass_textureCoords;
out vec4 output_color;

uniform sampler2D textureSampler;

void main(void) {
    //output_color = vec4(colour, 1.0);
    output_color = texture(textureSampler, pass_textureCoords);
}
