#version 400 core

in vec3 colour;
out vec4 output_color;

void main(void) {
    output_color = vec4(colour, 1.0);
}
