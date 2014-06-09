package br.com.hrdev.jdbcproject.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Controller implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

	@Override
	public void mouseDragged(MouseEvent event) {}

	@Override
	public void mouseMoved(MouseEvent event) {}

	@Override
	public void mouseClicked(MouseEvent event) {}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseExited(MouseEvent event) {}

	@Override
	public void mousePressed(MouseEvent eevent) {}

	@Override
	public void mouseReleased(MouseEvent event) {}

	@Override
	public void actionPerformed(ActionEvent event) {}

	@Override
	public void keyPressed(KeyEvent event) {}

	@Override
	public void keyReleased(KeyEvent event) {}

	@Override
	public void keyTyped(KeyEvent event) {}

}
