package glowna;

import ziarna.Ziarno0;
import ziarna.Ziarno1;
import ziarna.Ziarno0BeanInfo;

import java.awt.*;
import javax.swing.*;
import java.beans.PropertyVetoException;
import java.lang.String;
import java.awt.Color;

public class Main {



    public static void main(String[] args) throws PropertyVetoException {

        JButton zielony = new JButton("Zielony");
        JButton czerwony = new JButton("Czerwony");
        JButton czarny = new JButton("Czarny");
        JButton niebieski = new JButton("Niebieski");
        JButton zolty = new JButton("Zolty");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        JTextField tu_pisz = new JTextField("Wpisz kto kupil jablka",13);
        JButton zmien = new JButton("Potwierdz");
        JFrame ramka = new JFrame("Java Ziarno");

        JButton zmien1 = new JButton("Potwierdz");
        JTextField tu_pisz1 = new JTextField("Wpisz ile jablek kupil",13);


        Ziarno0 bean = new Ziarno0();
        Ziarno1 bean1 = new Ziarno1();
        Ziarno0BeanInfo info = new Ziarno0BeanInfo();

        ramka.setIconImage(info.getIcon(1));
        System.out.println(info.getBeanDescriptor());
        System.out.println(info.getPropertyDescriptors());

        zielony.addActionListener(actionEvent ->
        {
            bean.setZiarno_kolor(Color.green);
            bean.repaint();
        });

        czerwony.addActionListener(actionEvent ->
        {
            bean.setZiarno_kolor(Color.red);
            bean.repaint();
        });

        czarny.addActionListener(actionEvent ->
        {
            bean.setZiarno_kolor(Color.black);
            bean.repaint();
        });

        niebieski.addActionListener(actionEvent ->
        {
            bean.setZiarno_kolor(Color.blue);
            bean.repaint();
        });

        zolty.addActionListener(actionEvent ->
        {
            bean.setZiarno_kolor(Color.yellow);
            bean.repaint();
        });

        zmien.addActionListener(actionEvent ->
        {
            bean.setZiarno_tekst(tu_pisz.getText());
            SwingUtilities.updateComponentTreeUI(ramka);
        });

        zmien1.addActionListener(actionEvent ->
        {
            try {
                bean.setZiarno_wartosc(Integer.parseInt(tu_pisz1.getText()));
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(ramka);
        });


        bean.addPropertyChangeListener(bean1);
        bean.addVetoableChangeListener(bean1);

        bean.setZiarno_tekst("Kaczor Donald");
        ramka.setSize(500, 200);
        ramka.getContentPane().setLayout(new BorderLayout());
        ramka.getContentPane().add(panel, BorderLayout.NORTH);
        panel.add(zielony);
        panel.add(czerwony);
        panel.add(czarny);
        panel.add(zolty);
        panel.add(niebieski);


        panel1.setLayout(new GridLayout(2,2));
        ramka.getContentPane().add(panel1,BorderLayout.SOUTH);
        panel1.add(tu_pisz);
        panel1.add(zmien);
        panel1.add(tu_pisz1);
        panel1.add(zmien1);

        ramka.getContentPane().add(bean, BorderLayout.CENTER);
        ramka.setVisible(true);
    }
}
