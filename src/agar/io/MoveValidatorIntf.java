/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agar.io;

import java.awt.Point;

/**
 *
 * @author EthanChong
 */
public interface MoveValidatorIntf {
    public Point validateMove(Point proposedLocation);
}
