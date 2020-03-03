import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;



class ThreadPanel  extends JFrame{
  private static JPanel painel;
  private static JButton run;
  private static JButton pause;
  boolean started = false;
  boolean running = false;

  ArrayList<ThreadDemo> circulo = new ArrayList();
  ThreadPanel t;

  public ThreadPanel(ThreadDemo a, ThreadDemo b, ThreadDemo c, ThreadDemo d ){
    
    super("Thread Demo");
    circulo.add(a);
    circulo.add(b);
    circulo.add(c);
    circulo.add(d);
    setSize(600, 200);

    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    painel = new JPanel();
    painel.setLayout(new FlowLayout());



    run = new JButton("Run");
    pause = new JButton("Pause");

   

    run.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.out.println("Run");
        started = true;
        for(int i = 0; i < 4; i++){
          circulo.get(i).start();
          circulo.get(i).rodando = true;
        }
        running = true;

        
      }
    });


    pause.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.out.println("Pause");
        for(int i = 0; i< 4;i++){
          circulo.get(i).rodando = false;
          circulo.get(i).stop();

        }
        running = false;

      }
    });


    painel.add(run);
    painel.add(pause);

   

    add(painel, BorderLayout.SOUTH);
    setVisible(true);

  }

  public void paint(Graphics a){
    super.paint(a);
     
    for(int i = 0; i < 4; i++){
      a.setColor(circulo.get(i).cor);
      a.fillOval(20  + 150*i, 50, 100, 100);
      a.setColor(Color.red);
      a.fillArc(20 + 150*i,50, 100, 100,0, circulo.get(i).grau);
   
    }
  

  }
//metodo main
  public static void main(String args[]){
      ThreadDemo a = new ThreadDemo(Color.yellow, 9);
      ThreadDemo b = new ThreadDemo(Color.black, 8);
      ThreadDemo c = new ThreadDemo(Color.green, 5);
      ThreadDemo d = new ThreadDemo(Color.blue, 3);

      ThreadPanel t = new ThreadPanel(a, b, c, d);

      a.setCanvas(t);
      b.setCanvas(t);
      c.setCanvas(t);
      d.setCanvas(t);


  }


}
class ThreadDemo implements Runnable{
  
  Thread t = null;
  Color cor;
  ThreadPanel cv;
  boolean rodando = false;
  int grau;
  int inicio;

  ThreadDemo(Color color, int grau){
    cor = color;
    this.inicio = grau;
    this.grau = grau;
  }
  public void setCanvas(ThreadPanel tr){
    cv = tr;
  }
  synchronized void criterioStio() throws InterruptedException{
    while(cv.running == false)wait();
    notifyAll();
  }

  public void start(){
    if(t == null){
      t = new Thread(this);
      t.start();
    }
  }

  public void stop(){
    t = null;
  }

  public void run(){
    try{
      while(this.rodando){
        t.sleep(1000);
        cv.repaint();
        grau+=inicio;
        grau_();


      }

    }catch(InterruptedException e){}
  }

  public void grau_(){
    if(grau >= 360){
      grau = inicio;
    }
  }
}








