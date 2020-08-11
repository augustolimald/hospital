package main;

import controllers.EventLoop;
import controllers.FileManipulator;

public class Main {
    public static void main(String[] args) {
        try {
            EventLoop loop = new EventLoop();
            FileManipulator.fillData("/src/dadosEntrada.txt", loop);
            
            new Thread(loop).start();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro. Verifique a disponibilidade do arquivo e tente novamente");
        }
    }
}
