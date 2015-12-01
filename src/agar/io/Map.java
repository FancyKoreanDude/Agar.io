 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agar.io;

import environment.Environment;
import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author EthanChong
 */
class Map extends Environment implements CellDataProviderIntf, MoveValidatorIntf {
    
    private Grid grid;
    private Barrier myBarrier;
    private ArrayList<Barrier> barriers;
    private Cell myCell;

    public Map() {
        grid = new Grid(25, 20, 20, 20, new Point(10, 50), Color.GRAY);
//        myBarrier = new Barrier(10, 15, Color.MAGENTA, this);
//        
//        barriers = new ArrayList<>();
//        barriers.add(new Barrier(0, 0, Color.GREEN, this));
//        barriers.add(new Barrier(1, 0, Color.GREEN, this));
//        barriers.add(new Barrier(2, 0, Color.GREEN, this));
//        barriers.add(new Barrier(3, 0, Color.GREEN, this));
//        barriers.add(new Barrier(4, 0, Color.GREEN, this));
//        barriers.add(new Barrier(5, 0, Color.GREEN, this));
        
        
    }

    @Override
    public void initializeEnvironment() {
        
    }

    int counter;
    
    @Override
    public void timerTaskHandler() {
//        System.out.println("Hey dude " + ++counter);
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
//        System.out.println("Key Event" + e.getKeyChar());
//        System.out.println("Key Event" + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Go Left!!");
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Go Up!!");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Go Right!!");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Go Down!!");
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Key Released - UP");
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Key Released - LEFT");
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Key Released - DOWN");
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Key Released - Right");
        }
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("mouse click at " + e.getPoint());
        System.out.println("mouse click in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
           }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }
        
        if (myBarrier != null) {
            myBarrier.draw(graphics);
        }
        
        if (barriers != null) {
            for (int i = 0; i < barriers.size(); i++) {
                barriers.get(i).draw(graphics);
            }
        }
    }

    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;
    }

    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y; 
    }

    @Override
    public Point validateMove(Point proposedLocation) {
        return proposedLocation;
    }
    
}
