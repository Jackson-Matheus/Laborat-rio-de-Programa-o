#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

#include <GL\glew.h>
#include <GL\GLU.h>
#include <GL\freeglut.h>

void display()
{

    // Set every pixel in the frame buffer to the current clear color.
    glClear(GL_COLOR_BUFFER_BIT);

    // Drawing is done by specifying a sequence of vertices.  The way these
    // vertices are connected (or not connected) depends on the argument to
    // glBegin.  GL_POLYGON constructs a filled polygon.
    glBegin(GL_POLYGON);
    glColor3f(1, 0, 0);
    glVertex3f(-0.6, -0.75, 0.5);
    glColor3f(0, 1, 0);
    glVertex3f(0.6, -0.75, 0);
    glColor3f(0, 0, 1);
    glVertex3f(0, 0.75, 0);
    glEnd();

    // Flush drawing command buffer to make drawing happen as soon as possible.
    glFlush();
}

int main(int argc, char *argv[])
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
    // Cria uma janela de tamanho “largura” x “altura”
    glutInitWindowSize(largura, altura);
    glutCreateWindow("Segmentos Aleatorios");
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0.0, largura, 0.0, altura, -1.0, 1.0);
    // Seta a cor do fundo da janela
    glClearColor(1.0, 1.0, 1.0, 1.0);
    // Seta a função “display” como sendo a função que irá pintar a janela (infinitamente)
    glutDisplayFunc(display);
    glutMainLoop();

    int b = 0;
    int c = 0;

    return 0;
}